
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ShukanjuanzengEntity;
import com.entity.view.ShukanjuanzengView;
import com.service.DictionaryService;
import com.service.ShukanjuanzengService;
import com.service.TokenService;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 书刊捐赠
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shukanjuanzeng")
public class ShukanjuanzengController {
    private static final Logger logger = LoggerFactory.getLogger(ShukanjuanzengController.class);

    @Autowired
    private ShukanjuanzengService shukanjuanzengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shukanjuanzengService.queryPage(params);

        //字典表数据转换
        List<ShukanjuanzengView> list =(List<ShukanjuanzengView>)page.getList();
        for(ShukanjuanzengView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShukanjuanzengEntity shukanjuanzeng = shukanjuanzengService.selectById(id);
        if(shukanjuanzeng !=null){
            //entity转view
            ShukanjuanzengView view = new ShukanjuanzengView();
            BeanUtils.copyProperties( shukanjuanzeng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShukanjuanzengEntity shukanjuanzeng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shukanjuanzeng:{}",this.getClass().getName(),shukanjuanzeng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShukanjuanzengEntity> queryWrapper = new EntityWrapper<ShukanjuanzengEntity>()
            .eq("shukanjuanzeng_ren_name", shukanjuanzeng.getShukanjuanzengRenName())
            .eq("shukanjuanzeng_ren_phone", shukanjuanzeng.getShukanjuanzengRenPhone())
            .eq("shukanjuanzeng_ren_address", shukanjuanzeng.getShukanjuanzengRenAddress())
            .eq("shukanjuanzeng_uuid_number", shukanjuanzeng.getShukanjuanzengUuidNumber())
            .eq("shukanjuanzeng_name", shukanjuanzeng.getShukanjuanzengName())
            .eq("shukanjuanzeng_zuozhe", shukanjuanzeng.getShukanjuanzengZuozhe())
            .eq("tushu_types", shukanjuanzeng.getTushuTypes())
            .eq("chubanshe", shukanjuanzeng.getChubanshe())
            .eq("juanzengshuliang", shukanjuanzeng.getJuanzengshuliang())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShukanjuanzengEntity shukanjuanzengEntity = shukanjuanzengService.selectOne(queryWrapper);
        if(shukanjuanzengEntity==null){
            shukanjuanzeng.setInsertTime(new Date());
            shukanjuanzeng.setCreateTime(new Date());
            shukanjuanzengService.insert(shukanjuanzeng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShukanjuanzengEntity shukanjuanzeng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shukanjuanzeng:{}",this.getClass().getName(),shukanjuanzeng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ShukanjuanzengEntity> queryWrapper = new EntityWrapper<ShukanjuanzengEntity>()
            .notIn("id",shukanjuanzeng.getId())
            .andNew()
            .eq("shukanjuanzeng_ren_name", shukanjuanzeng.getShukanjuanzengRenName())
            .eq("shukanjuanzeng_ren_phone", shukanjuanzeng.getShukanjuanzengRenPhone())
            .eq("shukanjuanzeng_ren_address", shukanjuanzeng.getShukanjuanzengRenAddress())
            .eq("shukanjuanzeng_uuid_number", shukanjuanzeng.getShukanjuanzengUuidNumber())
            .eq("shukanjuanzeng_name", shukanjuanzeng.getShukanjuanzengName())
            .eq("shukanjuanzeng_zuozhe", shukanjuanzeng.getShukanjuanzengZuozhe())
            .eq("tushu_types", shukanjuanzeng.getTushuTypes())
            .eq("chubanshe", shukanjuanzeng.getChubanshe())
            .eq("juanzengshuliang", shukanjuanzeng.getJuanzengshuliang())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShukanjuanzengEntity shukanjuanzengEntity = shukanjuanzengService.selectOne(queryWrapper);
        if("".equals(shukanjuanzeng.getShukanjuanzengFengmianPhoto()) || "null".equals(shukanjuanzeng.getShukanjuanzengFengmianPhoto())){
                shukanjuanzeng.setShukanjuanzengFengmianPhoto(null);
        }
        if(shukanjuanzengEntity==null){
            shukanjuanzengService.updateById(shukanjuanzeng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shukanjuanzengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShukanjuanzengEntity> shukanjuanzengList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShukanjuanzengEntity shukanjuanzengEntity = new ShukanjuanzengEntity();
//                            shukanjuanzengEntity.setShukanjuanzengRenName(data.get(0));                    //捐赠人姓名 要改的
//                            shukanjuanzengEntity.setShukanjuanzengRenPhone(data.get(0));                    //捐赠人联系方式 要改的
//                            shukanjuanzengEntity.setShukanjuanzengRenAddress(data.get(0));                    //捐赠人住址 要改的
//                            shukanjuanzengEntity.setShukanjuanzengUuidNumber(data.get(0));                    //图书编号 要改的
//                            shukanjuanzengEntity.setShukanjuanzengName(data.get(0));                    //图书名称 要改的
//                            shukanjuanzengEntity.setShukanjuanzengZuozhe(data.get(0));                    //作者 要改的
//                            shukanjuanzengEntity.setShukanjuanzengFengmianPhoto("");//详情和图片
//                            shukanjuanzengEntity.setTushuTypes(Integer.valueOf(data.get(0)));   //图书类型 要改的
//                            shukanjuanzengEntity.setChubanshe(data.get(0));                    //出版社 要改的
//                            shukanjuanzengEntity.setChubanTime(sdf.parse(data.get(0)));          //出版日期 要改的
//                            shukanjuanzengEntity.setJuanzengshuliang(Integer.valueOf(data.get(0)));   //捐赠数量 要改的
//                            shukanjuanzengEntity.setShukanjuanzengContent("");//详情和图片
//                            shukanjuanzengEntity.setJuanzengTime(sdf.parse(data.get(0)));          //捐赠时间 要改的
//                            shukanjuanzengEntity.setInsertTime(date);//时间
//                            shukanjuanzengEntity.setCreateTime(date);//时间
                            shukanjuanzengList.add(shukanjuanzengEntity);


                            //把要查询是否重复的字段放入map中
                                //图书编号
                                if(seachFields.containsKey("shukanjuanzengUuidNumber")){
                                    List<String> shukanjuanzengUuidNumber = seachFields.get("shukanjuanzengUuidNumber");
                                    shukanjuanzengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shukanjuanzengUuidNumber = new ArrayList<>();
                                    shukanjuanzengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shukanjuanzengUuidNumber",shukanjuanzengUuidNumber);
                                }
                        }

                        //查询是否重复
                         //图书编号
                        List<ShukanjuanzengEntity> shukanjuanzengEntities_shukanjuanzengUuidNumber = shukanjuanzengService.selectList(new EntityWrapper<ShukanjuanzengEntity>().in("shukanjuanzeng_uuid_number", seachFields.get("shukanjuanzengUuidNumber")));
                        if(shukanjuanzengEntities_shukanjuanzengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShukanjuanzengEntity s:shukanjuanzengEntities_shukanjuanzengUuidNumber){
                                repeatFields.add(s.getShukanjuanzengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [图书编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shukanjuanzengService.insertBatch(shukanjuanzengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
