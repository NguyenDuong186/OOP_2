package fact;

import correlative.Correlative;
import entity.Entity;

public class Fact {
	private String correlative;
	private String obj;
	private String subj;
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public String getCorrelative() {
		return correlative;
	}
	public void setCorrelative(String correlative) {
		this.correlative = correlative;
	}
	public String getSubj() {
		return subj;
	}
	public void setSubj(String subj) {
		this.subj = subj;
	}
	@Override
	public String toString() {
		return "Fact [correlative=" + correlative + ", obj=" + obj + ", subj=" + subj + "]";
	}
	public Fact(String correlative, String obj, String subj) {
		super();
		this.correlative = correlative;
		this.obj = obj;
		this.subj = subj;
	}
	
	
	
}
