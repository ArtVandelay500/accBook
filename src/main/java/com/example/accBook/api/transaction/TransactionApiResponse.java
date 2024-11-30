package com.example.accBook.api.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransactionApiResponse {
    @JsonProperty("api_tran_id")
    private String apiTranId;

    @JsonProperty("api_tran_dtm")
    private String apiTranDtm;

    @JsonProperty("rsp_code")
    private String rspCode;

    @JsonProperty("rsp_message")
    private String rspMessage;

    @JsonProperty("bank_tran_id")
    private String bankTranId;

    @JsonProperty("bank_tran_date")
    private String bankTranDate;

    @JsonProperty("bank_code_tran")
    private String bankCodeTran;

    @JsonProperty("bank_rsp_code")
    private String bankRspCode;

    @JsonProperty("bank_rsp_message")
    private String bankRspMessage;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("fintech_use_num")
    private String fintechUseNum;

    @JsonProperty("balance_amt")
    private String balanceAmt;

    @JsonProperty("page_record_cnt")
    private String pageRecordCnt;

    @JsonProperty("next_page_yn")
    private String nextPageYn;

    @JsonProperty("befor_inquiry_trace_info")
    private String beforeInquiryTraceInfo;

    @JsonProperty("res_list")
    private List<Transaction> resList;

    // Getters and Setters

    @Data
    public static class Transaction {
        @JsonProperty("tran_date")
        private String tranDate;

        @JsonProperty("tran_time")
        private String tranTime;

        @JsonProperty("inout_type")
        private String inoutType;

        @JsonProperty("tran_type")
        private String tranType;

        @JsonProperty("printed_content")
        private String printedContent;

        @JsonProperty("tran_amt")
        private String tranAmt;

        @JsonProperty("after_balance_amt")
        private String afterBalanceAmt;

        @JsonProperty("branch_name")
        private String branchName;

        // Getters and Setters
    }
}
