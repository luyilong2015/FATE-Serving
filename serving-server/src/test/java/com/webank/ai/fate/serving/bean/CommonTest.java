package com.webank.ai.fate.serving.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.webank.ai.fate.api.mlmodel.manager.ModelServiceProto;
import com.webank.ai.fate.api.networking.common.CommonServiceProto;
import com.webank.ai.fate.api.serving.InferenceServiceProto;
import com.webank.ai.fate.serving.core.bean.BatchInferenceRequest;
import com.webank.ai.fate.serving.core.bean.InferenceRequest;
import com.webank.ai.fate.serving.core.flow.MetricNode;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommonTest {

    InferenceClient inferenceClient = new InferenceClient("localhost", 8000);

    @BeforeClass
    public static void init() {

    }

    @Test
    public void test_05_query_metric() {
        CommonServiceProto.QueryMetricRequest.Builder builder = CommonServiceProto.QueryMetricRequest.newBuilder();
        builder.setBeginMs(1589795475000l);
        builder.setEndMs(1589795523000l);
        builder.setSource("commonService");
        CommonServiceProto.CommonResponse resultMessage = inferenceClient.queryMetric(builder.build());

        List<MetricNode> list = JSONObject.parseObject(resultMessage.getData().toStringUtf8(), List.class);
        System.err.println("StatusCode ==================" + resultMessage.getStatusCode());
        System.err.println("Message ==================" + resultMessage.getMessage());
        System.err.println("result ==================" + JSONObject.toJSONString(list));
    }

    @Test
    public void test_06_update_rule() {
        CommonServiceProto.UpdateFlowRuleRequest.Builder builder = CommonServiceProto.UpdateFlowRuleRequest.newBuilder();
        builder.setSource("commonService");
        builder.setAllowQps(100);
        CommonServiceProto.CommonResponse resultMessage = inferenceClient.updateRule(builder.build());

        System.err.println("StatusCode ==================" + resultMessage.getStatusCode());
        System.err.println("Message ==================" + resultMessage.getMessage());
        System.err.println("result ==================" + resultMessage.getData().toStringUtf8());
    }

    @Test
    public void test_07_list_props() {
        CommonServiceProto.QueryPropsRequest.Builder builder = CommonServiceProto.QueryPropsRequest.newBuilder();
        builder.setKeyword("port");
        CommonServiceProto.CommonResponse resultMessage = inferenceClient.listProps(builder.build());

        System.err.println("StatusCode ==================" + resultMessage.getStatusCode());
        System.err.println("Message ==================" + resultMessage.getMessage());
        System.err.println("result ==================" + resultMessage.getData().toStringUtf8());
    }
}