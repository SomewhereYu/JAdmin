package com.goglezon.jadmin.model;

import org.springframework.stereotype.Repository;

/**
 * Created by Yuwenqi on 2015/9/12.
 */
@Repository
public class Sample {
    private int sampleId;
    private String sampleContent;

    public Sample(){};
    public Sample(int sampleId){
        this.sampleId=sampleId;
    }

    public void setSampleId(int sampleId){
        this.sampleId=sampleId;
    }

    public int getSampleId(){
        return this.sampleId;
    }

    public void setSampleContent(String sample_content){
        this.sampleContent=sample_content;
    }

    public String getSampleContent(){
        return this.sampleContent;
    }
}
