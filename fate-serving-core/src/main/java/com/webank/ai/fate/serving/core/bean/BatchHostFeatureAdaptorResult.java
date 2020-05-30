package com.webank.ai.fate.serving.core.bean;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * adaptor 专用
 */
public class BatchHostFeatureAdaptorResult {

    String retcode;
    String caseId;
    /**
     * key 为请求中的index
     */
    Map<Integer, SingleBatchHostFeatureAdaptorResult> indexResultMap = Maps.newHashMap();

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public Map<Integer, SingleBatchHostFeatureAdaptorResult> getIndexResultMap() {
        return indexResultMap;
    }

    public void setIndexResultMap(Map<Integer, SingleBatchHostFeatureAdaptorResult> indexResultMap) {
        this.indexResultMap = indexResultMap;
    }

    public static class SingleBatchHostFeatureAdaptorResult {

        int index;

        String retcode;

        String msg;
        Map<String, Object> features;

        public Map<String, Object> getFeatures() {
            return features;
        }

        public void setFeatures(Map<String, Object> features) {
            this.features = features;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getRetcode() {
            return retcode;
        }

        public void setRetcode(String retcode) {
            this.retcode = retcode;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }

}