package nju.software.xfgl.model;

// Generated 2014-7-21 0:36:58 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * DsrJb generated by hbm2java
 */
public class DsrJb implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer ajxh;
	
	private Integer dsrbh;
	
	private String dsrssdw;
	private String dsrlb;
	private String dsrjc;
	private String sfssdbr;
	private String dsrbgfs;
	private String dsrbgyy;
	private Date dsrbgsj;
	private String sfsa;
	private String sfsg;
	private String sfsq;
	private String sfst;
	private String sfsw;
	private String qqpcje;
	private String scbc;
	private String hpje;
	private int symbol;

	public DsrJb() {
	}

	public DsrJb(Integer ajxh, Integer dsrbh, int symbol) {
		this.ajxh = ajxh;
		this.dsrbh = dsrbh;
		this.symbol = symbol;
	}

	public DsrJb(Integer ajxh, Integer dsrbh, String dsrssdw, String dsrlb, String dsrjc,
			String sfssdbr, String dsrbgfs, String dsrbgyy, Date dsrbgsj,
			String sfsa, String sfsg, String sfsq, String sfst, String sfsw,
			String qqpcje, String scbc, String hpje, int symbol) {
		this.ajxh = ajxh;
		this.dsrbh = dsrbh;
		this.dsrssdw = dsrssdw;
		this.dsrlb = dsrlb;
		this.dsrjc = dsrjc;
		this.sfssdbr = sfssdbr;
		this.dsrbgfs = dsrbgfs;
		this.dsrbgyy = dsrbgyy;
		this.dsrbgsj = dsrbgsj;
		this.sfsa = sfsa;
		this.sfsg = sfsg;
		this.sfsq = sfsq;
		this.sfst = sfst;
		this.sfsw = sfsw;
		this.qqpcje = qqpcje;
		this.scbc = scbc;
		this.hpje = hpje;
		this.symbol = symbol;
	}

	public Integer getAjxh() {
		return ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	public Integer getDsrbh() {
		return dsrbh;
	}

	public void setDsrbh(Integer dsrbh) {
		this.dsrbh = dsrbh;
	}

	public String getDsrssdw() {
		return this.dsrssdw;
	}

	public void setDsrssdw(String dsrssdw) {
		this.dsrssdw = dsrssdw;
	}

	public String getDsrlb() {
		return this.dsrlb;
	}

	public void setDsrlb(String dsrlb) {
		this.dsrlb = dsrlb;
	}

	public String getDsrjc() {
		return this.dsrjc;
	}

	public void setDsrjc(String dsrjc) {
		this.dsrjc = dsrjc;
	}

	public String getSfssdbr() {
		return this.sfssdbr;
	}

	public void setSfssdbr(String sfssdbr) {
		this.sfssdbr = sfssdbr;
	}

	public String getDsrbgfs() {
		return this.dsrbgfs;
	}

	public void setDsrbgfs(String dsrbgfs) {
		this.dsrbgfs = dsrbgfs;
	}

	public String getDsrbgyy() {
		return this.dsrbgyy;
	}

	public void setDsrbgyy(String dsrbgyy) {
		this.dsrbgyy = dsrbgyy;
	}

	public Date getDsrbgsj() {
		return this.dsrbgsj;
	}

	public void setDsrbgsj(Date dsrbgsj) {
		this.dsrbgsj = dsrbgsj;
	}

	public String getSfsa() {
		return this.sfsa;
	}

	public void setSfsa(String sfsa) {
		this.sfsa = sfsa;
	}

	public String getSfsg() {
		return this.sfsg;
	}

	public void setSfsg(String sfsg) {
		this.sfsg = sfsg;
	}

	public String getSfsq() {
		return this.sfsq;
	}

	public void setSfsq(String sfsq) {
		this.sfsq = sfsq;
	}

	public String getSfst() {
		return this.sfst;
	}

	public void setSfst(String sfst) {
		this.sfst = sfst;
	}

	public String getSfsw() {
		return this.sfsw;
	}

	public void setSfsw(String sfsw) {
		this.sfsw = sfsw;
	}

	public String getQqpcje() {
		return this.qqpcje;
	}

	public void setQqpcje(String qqpcje) {
		this.qqpcje = qqpcje;
	}

	public String getScbc() {
		return this.scbc;
	}

	public void setScbc(String scbc) {
		this.scbc = scbc;
	}

	public String getHpje() {
		return this.hpje;
	}

	public void setHpje(String hpje) {
		this.hpje = hpje;
	}

	public int getSymbol() {
		return this.symbol;
	}

	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}

}
