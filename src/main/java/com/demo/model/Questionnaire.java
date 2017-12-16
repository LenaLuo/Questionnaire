package com.demo.model;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



//@Entity
//@Table(name="Questionnaire")
@Document(collection="Questionnaire")
public class Questionnaire{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger id;

	@Field("Question Number")
	private Long qNumber;
	
	@Field("Question Type")
	private String qType;
	
	@Field("Question Name")
	private String qName;
	
	@Field("Question")
	private String question;
	
	@Field("Answer")
	private String answer;
	
	@Field("Processer")
	private String processor;
	
	@Field("Activity")
	private String activity;
	
	@Field("Risk Level")
	private String riskLevel;
	
	@Field("Created At")
	private Timestamp createdAt;
	
	@Field("Modified At")
	private Timestamp modifiedAt;
	
	@Field("Created By")
	private String createdBy;
	
	@Field("Modified By")
	private String modifiedBy;
	
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Long getqNumber() {
		return qNumber;
	}

	public void setqNumber(Long qNumber) {
		this.qNumber = qNumber;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	//无参构造函数
	public Questionnaire(){
		super();
	}

	public Questionnaire( Long qNumber, String qType, String qName,
			String question, String answer, String processor, String activity,
			String riskLevel, Timestamp createdAt, Timestamp modifiedAt,
			String createdBy, String modifiedBy) {
		super();
//		this.id = id;
		this.qNumber = qNumber;
		this.qType = qType;
		this.qName = qName;
		this.question = question;
		this.answer = answer;
		this.processor = processor;
		this.activity = activity;
		this.riskLevel = riskLevel;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}
	
	

	public Questionnaire( Long qNumber, String qType) {
		this.qNumber = qNumber;
		this.qType  = qType;
	}

	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", qNumber=" + qNumber + ", qType="
				+ qType + ", qName=" + qName + ", question=" + question
				+ ", answer=" + answer + ", processor=" + processor
				+ ", activity=" + activity + ", riskLevel=" + riskLevel
				+ ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ "]";
	}
	
	
	
}
