package com.primihub.biz.entity.data.req;

import com.alibaba.fastjson.JSONObject;
import com.primihub.biz.entity.data.po.*;
import com.primihub.biz.entity.data.vo.ModelProjectResourceVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.*;

@Data
@Slf4j
public class  ComponentTaskReq {
    private DataModel dataModel;
    private DataModelTask dataModelTask;
    private DataTask dataTask;
    private List<DataModelResource> dmrList = new ArrayList<>();
    private List<ModelProjectResourceVo> resourceList;
    private Map<String,String> freemarkerMap = new HashMap<>();
    private DataModelAndComponentReq modelComponentReq = null;
    private List<DataModelComponent> dataModelComponents = new ArrayList<>();
    private List<DataComponent> dataComponents = new ArrayList<>();
    private Map<String, String> valueMap = new HashMap<>();
    private List<LinkedHashMap<String,Object>> fusionResourceList;

    public ComponentTaskReq(DataModel dataModel) {
        this.dataModel = dataModel;
        this.dataTask = new DataTask();
    }

    public DataModelAndComponentReq getModelComponentReq(){
        if (modelComponentReq!=null)
            return modelComponentReq;
        try {
            if (StringUtils.isNotBlank(dataModel.getComponentJson())) {
                modelComponentReq  = JSONObject.parseObject(dataModel.getComponentJson(), DataModelAndComponentReq.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return modelComponentReq;
    }
}
