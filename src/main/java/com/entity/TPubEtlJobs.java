package com.entity;

import src.afsql.annotation.AFTABLE;

/**
 * 本类由 POJO生成器 自动生成于 2022-08-21 21:29:58
 * 作者：阿发你好      官网: http://afanihao.cn
 * INSERT语句 ( 预处理方式 )
 * INSERT INTO `t_pub_etl_jobs`
 * (`job_id`, `job_seq`, `job_type`, `src_system_id`, `des_system_id`, `src_object_name`, `des_object_name`, `src_object_desc`, `condition`, `cols`, `frequency`, `valid_flag`, `last_update`, `job_name`, `module_type`, `job_script_name`, `ddl_auto_sync`, `ddl_specific`, `cols_cal_def`, `cols_cal_exp`, `core_byte`, `job_byte`, `core_record`, `job_record`, `job_channel`, `job_jvm_xms`, `job_jvm_xmx`)
 * VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 * INSERT语句 ( 预处理方式 )
 * INSERT INTO `t_pub_etl_jobs`
 * (`job_id`, `job_seq`, `job_type`, `src_system_id`, `des_system_id`, `src_object_name`, `des_object_name`, `src_object_desc`, `condition`, `cols`, `frequency`, `valid_flag`, `last_update`, `job_name`, `module_type`, `job_script_name`, `ddl_auto_sync`, `ddl_specific`, `cols_cal_def`, `cols_cal_exp`, `core_byte`, `job_byte`, `core_record`, `job_record`, `job_channel`, `job_jvm_xms`, `job_jvm_xmx`)
 * VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 */

/** INSERT语句 ( 预处理方式 ) 
 INSERT INTO `t_pub_etl_jobs`
 (`job_id`, `job_seq`, `job_type`, `src_system_id`, `des_system_id`, `src_object_name`, `des_object_name`, `src_object_desc`, `condition`, `cols`, `frequency`, `valid_flag`, `last_update`, `job_name`, `module_type`, `job_script_name`, `ddl_auto_sync`, `ddl_specific`, `cols_cal_def`, `cols_cal_exp`, `core_byte`, `job_byte`, `core_record`, `job_record`, `job_channel`, `job_jvm_xms`, `job_jvm_xmx`)
 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 */

/** INSERT语句 ( MyBatis方式 )
 INSERT INTO `t_pub_etl_jobs`
 (`job_id`, `job_seq`, `job_type`, `src_system_id`, `des_system_id`, `src_object_name`, `des_object_name`, `src_object_desc`, `condition`, `cols`, `frequency`, `valid_flag`, `last_update`, `job_name`, `module_type`, `job_script_name`, `ddl_auto_sync`, `ddl_specific`, `cols_cal_def`, `cols_cal_exp`, `core_byte`, `job_byte`, `core_record`, `job_record`, `job_channel`, `job_jvm_xms`, `job_jvm_xmx`)
 VALUES(#{job_id}, #{job_seq}, #{job_type}, #{src_system_id}, #{des_system_id}, #{src_object_name}, #{des_object_name}, #{src_object_desc}, #{condition}, #{cols}, #{frequency}, #{valid_flag}, #{last_update}, #{job_name}, #{module_type}, #{job_script_name}, #{ddl_auto_sync}, #{ddl_specific}, #{cols_cal_def}, #{cols_cal_exp}, #{core_byte}, #{job_byte}, #{core_record}, #{job_record}, #{job_channel}, #{job_jvm_xms}, #{job_jvm_xmx})

 自增主键: job_id
 */

@AFTABLE(name = "t_pub_etl_jobs")
public class TPubEtlJobs {

    public Integer job_id;
    public Integer job_seq;
    public String job_type;
    public String src_system_id;
    public String des_system_id;
    public String src_object_name;
    public String des_object_name;
    public String src_object_desc;
    public String condition;
    public String cols;
    public Byte frequency;
    public Byte valid_flag;
    public String last_update;
    public String job_name;
    public String module_type;
    public String job_script_name;
    public Boolean ddl_auto_sync;
    public String ddl_specific;
    public String cols_cal_def;
    public String cols_cal_exp;
    public Integer core_byte;
    public Integer job_byte;
    public Integer core_record;
    public Integer job_record;
    public Integer job_channel;
    public Integer job_jvm_xms;
    public Integer job_jvm_xmx;


    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getJob_id() {
        return this.job_id;
    }

    public void setJob_seq(Integer job_seq) {
        this.job_seq = job_seq;
    }

    public Integer getJob_seq() {
        return this.job_seq;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_type() {
        return this.job_type;
    }

    public void setSrc_system_id(String src_system_id) {
        this.src_system_id = src_system_id;
    }

    public String getSrc_system_id() {
        return this.src_system_id;
    }

    public void setDes_system_id(String des_system_id) {
        this.des_system_id = des_system_id;
    }

    public String getDes_system_id() {
        return this.des_system_id;
    }

    public void setSrc_object_name(String src_object_name) {
        this.src_object_name = src_object_name;
    }

    public String getSrc_object_name() {
        return this.src_object_name;
    }

    public void setDes_object_name(String des_object_name) {
        this.des_object_name = des_object_name;
    }

    public String getDes_object_name() {
        return this.des_object_name;
    }

    public void setSrc_object_desc(String src_object_desc) {
        this.src_object_desc = src_object_desc;
    }

    public String getSrc_object_desc() {
        return this.src_object_desc;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCols(String cols) {
        this.cols = cols;
    }

    public String getCols() {
        return this.cols;
    }

    public void setFrequency(Byte frequency) {
        this.frequency = frequency;
    }

    public Byte getFrequency() {
        return this.frequency;
    }

    public void setValid_flag(Byte valid_flag) {
        this.valid_flag = valid_flag;
    }

    public Byte getValid_flag() {
        return this.valid_flag;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getLast_update() {
        return this.last_update;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getJob_name() {
        return this.job_name;
    }

    public void setModule_type(String module_type) {
        this.module_type = module_type;
    }

    public String getModule_type() {
        return this.module_type;
    }

    public void setJob_script_name(String job_script_name) {
        this.job_script_name = job_script_name;
    }

    public String getJob_script_name() {
        return this.job_script_name;
    }

    public void setDdl_auto_sync(Boolean ddl_auto_sync) {
        this.ddl_auto_sync = ddl_auto_sync;
    }

    public Boolean getDdl_auto_sync() {
        return this.ddl_auto_sync;
    }

    public void setDdl_specific(String ddl_specific) {
        this.ddl_specific = ddl_specific;
    }

    public String getDdl_specific() {
        return this.ddl_specific;
    }

    public void setCols_cal_def(String cols_cal_def) {
        this.cols_cal_def = cols_cal_def;
    }

    public String getCols_cal_def() {
        return this.cols_cal_def;
    }

    public void setCols_cal_exp(String cols_cal_exp) {
        this.cols_cal_exp = cols_cal_exp;
    }

    public String getCols_cal_exp() {
        return this.cols_cal_exp;
    }

    public void setCore_byte(Integer core_byte) {
        this.core_byte = core_byte;
    }

    public Integer getCore_byte() {
        return this.core_byte;
    }

    public void setJob_byte(Integer job_byte) {
        this.job_byte = job_byte;
    }

    public Integer getJob_byte() {
        return this.job_byte;
    }

    public void setCore_record(Integer core_record) {
        this.core_record = core_record;
    }

    public Integer getCore_record() {
        return this.core_record;
    }

    public void setJob_record(Integer job_record) {
        this.job_record = job_record;
    }

    public Integer getJob_record() {
        return this.job_record;
    }

    public void setJob_channel(Integer job_channel) {
        this.job_channel = job_channel;
    }

    public Integer getJob_channel() {
        return this.job_channel;
    }

    public void setJob_jvm_xms(Integer job_jvm_xms) {
        this.job_jvm_xms = job_jvm_xms;
    }

    public Integer getJob_jvm_xms() {
        return this.job_jvm_xms;
    }

    public void setJob_jvm_xmx(Integer job_jvm_xmx) {
        this.job_jvm_xmx = job_jvm_xmx;
    }

    public Integer getJob_jvm_xmx() {
        return this.job_jvm_xmx;
    }

    @Override
    public String toString() {
        return "TPubEtlJobs{" +
                "job_id=" + job_id +
                ", job_seq=" + job_seq +
                ", job_type='" + job_type + '\'' +
                ", src_system_id='" + src_system_id + '\'' +
                ", des_system_id='" + des_system_id + '\'' +
                ", src_object_name='" + src_object_name + '\'' +
                ", des_object_name='" + des_object_name + '\'' +
                ", src_object_desc='" + src_object_desc + '\'' +
                ", condition='" + condition + '\'' +
                ", cols='" + cols + '\'' +
                ", frequency=" + frequency +
                ", valid_flag=" + valid_flag +
                ", last_update='" + last_update + '\'' +
                ", job_name='" + job_name + '\'' +
                ", module_type='" + module_type + '\'' +
                ", job_script_name='" + job_script_name + '\'' +
                ", ddl_auto_sync=" + ddl_auto_sync +
                ", ddl_specific='" + ddl_specific + '\'' +
                ", cols_cal_def='" + cols_cal_def + '\'' +
                ", cols_cal_exp='" + cols_cal_exp + '\'' +
                ", core_byte=" + core_byte +
                ", job_byte=" + job_byte +
                ", core_record=" + core_record +
                ", job_record=" + job_record +
                ", job_channel=" + job_channel +
                ", job_jvm_xms=" + job_jvm_xms +
                ", job_jvm_xmx=" + job_jvm_xmx +
                '}';
    }
}
 