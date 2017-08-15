/*登录 
*para user_id , password
*return true/false
**/

CREATE PROCEDURE procedure_login(IN user_id varchar(20), IN password varchar(20))
BEGIN
	select password from awell_remote_file_dir.user where user_id
END 


/*注册
 * para user_id, password，nickname
 * return true/false
 * */
