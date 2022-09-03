package com.entity; 

import com.utils.MyUtil;
import src.afsql.annotation.AFCOLUMNS;
import src.afsql.annotation.AFTABLE;
import src.afsql.util.AfSqlStringUtils;

import java.util.Map;

/** INSERT语句 ( 预处理方式 ) 
  INSERT INTO `t_pub_etl_logs`
        (`id`, `job_name`, `src_object_name`, `des_object_name`, `datax_script_name`, `datax_start_time`, `datax_end_time`, `datax_elapsed`, `datax_avg_flowrate`, `datax_input_speed`, `datax_output_num`, `datax_fail_num`, `start_time`, `end_time`, `elapsed`, `status`, `status_desc`, `is_successful`, `param_info`, `error_1`, `error_2`, `error_3`, `rec_create_time`) 
  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
*/ 

/** INSERT语句 ( MyBatis方式 ) 
  INSERT INTO `t_pub_etl_logs`
        (`id`, `job_name`, `src_object_name`, `des_object_name`, `datax_script_name`, `datax_start_time`, `datax_end_time`, `datax_elapsed`, `datax_avg_flowrate`, `datax_input_speed`, `datax_output_num`, `datax_fail_num`, `start_time`, `end_time`, `elapsed`, `status`, `status_desc`, `is_successful`, `param_info`, `error_1`, `error_2`, `error_3`, `rec_create_time`) 
  VALUES(#{id}, #{job_name}, #{src_object_name}, #{des_object_name}, #{datax_script_name}, #{datax_start_time}, #{datax_end_time}, #{datax_elapsed}, #{datax_avg_flowrate}, #{datax_input_speed}, #{datax_output_num}, #{datax_fail_num}, #{start_time}, #{end_time}, #{elapsed}, #{status}, #{status_desc}, #{is_successful}, #{param_info}, #{error_1}, #{error_2}, #{error_3}, #{rec_create_time}) 

  自增主键: id
*/ 

@AFTABLE(name="t_pub_etl_logs")
@AFCOLUMNS(generated="id")
public class TPubEtlLogs 
{
	public Integer id ; 
	public String job_name ; 
	public String src_object_name ; 
	public String des_object_name ; 
	public String datax_script_name ; 
	public String datax_start_time ; 
	public String datax_end_time ; 
	public String datax_elapsed ; 
	public String datax_avg_flowrate ; 
	public String datax_input_speed ; 
	public String datax_output_num ; 
	public String datax_fail_num ; 
	public String start_time ; 
	public String end_time ; 
	public String elapsed ; 
	public String status ; 
	public String status_desc ; 
	public String is_successful ; 
	public String param_info ; 
	public String error_1 ; 
	public String error_2 ; 
	public String error_3 ; 
	public String rec_create_time ;

	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return this.id;
	}
	public void setJob_name(String job_name)
	{
		this.job_name=job_name;
	}
	public String getJob_name()
	{
		return this.job_name;
	}
	public void setSrc_object_name(String src_object_name)
	{
		this.src_object_name=src_object_name;
	}
	public String getSrc_object_name()
	{
		return this.src_object_name;
	}
	public void setDes_object_name(String des_object_name)
	{
		this.des_object_name=des_object_name;
	}
	public String getDes_object_name()
	{
		return this.des_object_name;
	}
	public void setDatax_script_name(String datax_script_name)
	{
		this.datax_script_name=datax_script_name;
	}
	public String getDatax_script_name()
	{
		return this.datax_script_name;
	}
	public void setDatax_start_time(String datax_start_time)
	{
		this.datax_start_time=datax_start_time;
	}
	public String getDatax_start_time()
	{
		return this.datax_start_time;
	}
	public void setDatax_end_time(String datax_end_time)
	{
		this.datax_end_time=datax_end_time;
	}
	public String getDatax_end_time()
	{
		return this.datax_end_time;
	}
	public void setDatax_elapsed(String datax_elapsed)
	{
		this.datax_elapsed=datax_elapsed;
	}
	public String getDatax_elapsed()
	{
		return this.datax_elapsed;
	}
	public void setDatax_avg_flowrate(String datax_avg_flowrate)
	{
		this.datax_avg_flowrate=datax_avg_flowrate;
	}
	public String getDatax_avg_flowrate()
	{
		return this.datax_avg_flowrate;
	}
	public void setDatax_input_speed(String datax_input_speed)
	{
		this.datax_input_speed=datax_input_speed;
	}
	public String getDatax_input_speed()
	{
		return this.datax_input_speed;
	}
	public void setDatax_output_num(String datax_output_num)
	{
		this.datax_output_num=datax_output_num;
	}
	public String getDatax_output_num()
	{
		return this.datax_output_num;
	}
	public void setDatax_fail_num(String datax_fail_num)
	{
		this.datax_fail_num=datax_fail_num;
	}
	public String getDatax_fail_num()
	{
		return this.datax_fail_num;
	}
	public void setStart_time(String start_time)
	{
		this.start_time=start_time;
	}
	public String getStart_time()
	{
		return this.start_time;
	}
	public void setEnd_time(String end_time)
	{
		this.end_time=end_time;
	}
	public String getEnd_time()
	{
		return this.end_time;
	}
	public void setElapsed(String elapsed)
	{
		this.elapsed=elapsed;
	}
	public String getElapsed()
	{
		return this.elapsed;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	public String getStatus()
	{
		return this.status;
	}
	public void setStatus_desc(String status_desc)
	{
		this.status_desc=status_desc;
	}
	public String getStatus_desc()
	{
		return this.status_desc;
	}
	public void setIs_successful(String is_successful)
	{
		this.is_successful=is_successful;
	}
	public String getIs_successful()
	{
		return this.is_successful;
	}
	public void setParam_info(String param_info)
	{
		this.param_info=param_info;
	}
	public String getParam_info()
	{
		return this.param_info;
	}
	public void setError_1(String error_1)
	{
		this.error_1=error_1;
	}
	public String getError_1()
	{
		return this.error_1;
	}
	public void setError_2(String error_2)
	{
		this.error_2=error_2;
	}
	public String getError_2()
	{
		return this.error_2;
	}
	public void setError_3(String error_3)
	{
		this.error_3=error_3;
	}
	public String getError_3()
	{
		return this.error_3;
	}
	public void setRec_create_time(String rec_create_time)
	{
		this.rec_create_time=rec_create_time;
	}
	public String getRec_create_time()
	{
		return this.rec_create_time;
	}

	/**
	 * 传入的MAP转换为配置类的属性
	 * @param map Map
	 * @return 当前对象
	 */
	public TPubEtlLogs fromMap(Map<String, String> map) {
		String time = MyUtil.getPresentDateTime();
		setJob_name(AfSqlStringUtils.defaultIfEmpty(map.get("job_name"), ""));
		setSrc_object_name(AfSqlStringUtils.defaultIfEmpty(map.get("src_object_name"), ""));
		setDes_object_name(AfSqlStringUtils.defaultIfEmpty(map.get("des_object_name"), ""));
		setDatax_script_name(AfSqlStringUtils.defaultIfEmpty(map.get("datax_script_name"), ""));
		setDatax_start_time(AfSqlStringUtils.defaultIfEmpty(map.get("datax_start_time"), ""));
		setDatax_end_time(AfSqlStringUtils.defaultIfEmpty(map.get("datax_end_time"), ""));
		setDatax_elapsed(AfSqlStringUtils.defaultIfEmpty(map.get("datax_elapsed"), ""));
		setDatax_avg_flowrate(AfSqlStringUtils.defaultIfEmpty(map.get("datax_avg_flowrate"), ""));
		setDatax_input_speed(AfSqlStringUtils.defaultIfEmpty(map.get("datax_input_speed"), ""));
		setDatax_output_num(AfSqlStringUtils.defaultIfEmpty(map.get("datax_output_num"), ""));
		setDatax_fail_num(AfSqlStringUtils.defaultIfEmpty(map.get("datax_fail_num"), ""));
		setStart_time(AfSqlStringUtils.defaultIfEmpty(map.get("start_time"), ""));
		setEnd_time(AfSqlStringUtils.defaultIfEmpty(map.get("end_time"), time));
		setElapsed(AfSqlStringUtils.defaultIfEmpty(map.get("elapsed"), ""));
		setStatus(AfSqlStringUtils.defaultIfEmpty(map.get("status"), ""));
		setStatus_desc(AfSqlStringUtils.defaultIfEmpty(map.get("status_desc"), ""));
		setIs_successful(AfSqlStringUtils.defaultIfEmpty(map.get("is_successful"), "T"));
		setParam_info(AfSqlStringUtils.defaultIfEmpty(map.get("param_info"), ""));
		setError_1(AfSqlStringUtils.defaultIfEmpty(map.get("error_1"), ""));
		setError_2(AfSqlStringUtils.defaultIfEmpty(map.get("error_2"), ""));
		setError_3(AfSqlStringUtils.defaultIfEmpty(map.get("error_3"), ""));
		setRec_create_time(AfSqlStringUtils.defaultIfEmpty(map.get("rec_create_time"), time));

		return this;
	}

} 
 