package com.sw.basis.dto;
/**
 * EnumUserDefinedError
 * @author jixing2000
 **/
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum DefinedErrorEnum {
    NO_ERROR (0, "", ""),
    NOT_LOGGEDIN (-1, "user not logged in", "用户未登录"),
    USER_NOT_EXISTS (-2, "user does not exist", "用户不存在"),
    TOKEN_EXPIRED (-9, "token expired, please re-login", "token过期,请重新登录"),
    NOT_OLDPWD_WRONG (-10, "incorrect old password", "旧密码不正确"),
    USER_PWD_UNCHANGED(-98, "The password has not been changed for 3 months", "密码已经3个月未修改"),
    LOGIN_FAILED(-99, "user code or password wrong", "错误的用户名或密码"),
    INVALID_USER_ROLE(-100, "Invalid User Role", "用户角色错误"),
    INVALID_ACCESS(-80, "Access NOT Allowded", "未允许的访问"),

    USER_MISSING_PHONE(-50, "user phone number is null", "电话号码为空"),
    USER_MISSING_EMAIL(-51, "user email is null", "邮箱为空"),
    USER_MISSING_USERCODE(-52, "user code is null", "员工编号为空"),
    USER_NOT_EXISTED(-56,"The user does not exist","用户不存在"),
    
    PROJECT_MISSING_PROJECTID(-53,"project id is null","项目ID为空"),
    PROJECT_MISSING_BIZTYPEID(-54,"biztype id is null","业务类型ID为空"),
    PROJECT_MISSING_CONTACTCODE(-55,"contact code is null","联系人编码为空"),


    USER_DUPLICATED_PHONE(-40, "user phone existed", "电话号码重复"),
    USER_DUPLICATED_EMAIL(-41, "user email existed", "邮箱重复"),
    USER_DUPLICATED_CODE(-42, "user code existed", "员工编号重复"),

    MD_CLIENT_EXISTED(-70, "client already existed", "客户已存在"),
    MD_DEL_ASSOCIATED_CLIENT(-71, "delete associated client", "客户已发生业务,不能删除"),
    MD_DEL_ASSOCIATED_CONTACT(-72, "delete associated contect", "联系人已在项目中使用,不能删除"),

    USER_LAYOFF_WORKPAPERS_NOTDONE(-61, "user has unfinished workpapers", "有未完成的底稿"),
    
    USER_NO_PRIVILEGE(-88, "No Privilege", "没有操作权限"),
    USER_NOTIN_PROJECT(-89, "you are not in this project team", "您没有在本项目团队中"),

    WP_NOT_EXIST(-110, "workpaper does not exist", "底稿不存在"),
    WP_DUPLICATED_INDEXNUMBER(-111, "Index number existed in this project already", "该底稿索引号在项目中已经存在"),
    WP_NULL_CODE(-112, "workpaper code must not be null", "底稿索引号不能为空"),
    WP_ATTACH_DUPLICATED_INDEXNUMBER(-120, "index number existed in this project", "该附件索引号在项目中已经存在"),
    WP_INVALID_CLASS(-150, "wrong workpaper class", "底稿类型错误"),
       
    INVALID_PARAMETERS(-200, "Invalid Parameters", "参数无效"),
    PRJ_MEMBER_SELF_REMOVE(-250, "You can not remove yourself", "不能删除自己"),
    PRJ_MEMBER_ILLEGAL_REMOVE(-251, "You can not remove a necessary member", "不能删除必要的成员"),
    PRJ_MEMBER_ILLEGAL_CHANGE(-252, "Can not change this row because there must be at least one member has this role in this project", "不能更改必要的成员角色"),
    PRJ_TEAM_NO_NECESSARY_ROLE (-253, "Project team lacks necessary roles", "项目组缺乏必要的角色"),
    PRJ_MEMBER_SELF_MODIFY(-254, "You can not change the project role of yourself", "您不能更新自己的项目角色"),
    
    OBJECT_EXISTED(-300, "the object to be added already existed", "要被添加的对象已存在"),
    OBJECT_NOT_EXIST(-320, "the business object requested does not exist", "请求的业务对象不存在"), 
    INVALID_PROJECT_ROLE(-310, "invalid project role", "项目角色错误"),
    INVALID_PROJECT_STATUS(-330, "invalid project status", "项目状态错误"),
    
    INVALID_WORKPAPER_STATUS(-400, "Invalid Workpaper Status", "底稿状态错误"),
    INVALID_FILE_ID(-401, "Invalid File ID", "无效的文件ID"),
    WP_BLANK_FILE(-450, "No file assicated with this work paper, please upload a file directly", "底稿无对应的文件，请直接上传文件"),
    CLOSEPRJ_WP_NOT_FINISHED(-600, "Work papers are not completedly done", "底稿尚未全部完成"),

    INVALID_REVIEWER(-250, "Invalid Reviewer", "无效的复核人"),
    INVALID_CONTACT(-251, "Invalid Contact", "无效的联系人"),
    INVALID_BIZ_TYPE(-252,"Invalid business type","无效的业务类型"),

    TREE_NOROOT (-500, "No root node in task tree", "树中没有根节点"),
    TREE_MULITIPLE_ROOT(-501, "More than 1 root node in task tree", "树中根节点多于1个"),

    TASKID_NOT_EXIST(-502, "project taskid does not exist", "任务节点不存在"),
    TASK_L1_NOT_ADDABLE(-504, "can not add project task of level 1", "不能添加一级任务节点"),
    TASK_L1_NOT_DELETABLE(-503, "root node and project tasks of level 1 can not be deleted", "根节点和一级任务节点不能删除"),
    TASK_WITH_WPS_NOT_DELETABLE (-510, "project task can not be deleted with workpapers in the sub-tree", "任务或其子任务有底稿，不能删除"),
    TASK__MISSING_TASKNAME(-511, "the task name cannot be empty ","任务名称不能为空"),
    TASK_REVIEWER_ERROR(-512, "You are not the current reviewer", "您不是当前复核人"),

    TEMPLATE_TASK_NAME_EXISTED(-700,"The template name already exists","模板名称已存在"),
    TEMPLATE_TASK_ERROR(-701, " You cannot create a manuscript template in the root directory", "不能在根目录下创建底稿模板"),
    TEMPLATE_TASK_NOT_EXIST(-702,"Template does not exist","模板不存在"),
    
    TEMPLATE_WP_TAG_EXISTED(-750,"Template tag name already existed","底稿模板标签已存在"),

    FDFS_ERROR(-1000, "File Management System Error", "文件管理系统错误"),
    FDFS_FILE_NOT_EXIST(-1001, "file does not exist", "文件不存在"),

    APP_VAR_NODEFINITION ( -1200, "Variable not defined", "变量未定义"),
    APP_VAR_WRONGVALUE ( -1210, "Invalid variable value", "变量值错误");
    
    private int value;
    private String message, messageSecond;
    
    DefinedErrorEnum(int value, String message, String messageSec) {
        this.value = value;
        this.message= message;
        this.messageSecond = messageSec;
        
    }
    public int getValue() {
        return value;
    }
    public void setValue(int val) {
        value=val;
    }

    public String getMessage(){
        return getMessage("zh");
    }

    public String getMessage(String lang){
        if (lang==null || "en".equalsIgnoreCase(lang)) {
            return message;
        } else {
            return messageSecond;
        }
    }
    
    
    public void setMessage(String message) {
        this.message = message;
    }
        
    public void setMessageSecondLanguage(String message) {
            this.messageSecond = message;
    }        
}
