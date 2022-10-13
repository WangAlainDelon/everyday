package leetcode.string;

public class Test {
    private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则

    public static void main(String[] args) {


        String msg = "error.nexus.client.component=组件Id错误\n" +
                "error.nexus.client.repo.type=仓库类型错误\n" +
                "error.nexus.client.repo.name.exist=仓库名，对应仓库已存在\n" +
                "error.nexus.client.role.exist=角色ID对应角色已存在\n" +
                "error.nexus.client.user.exist=用户ID对应用户已存在\n" +
                "error.nexus.client.nexus.not.conf=nexus服务信息未配置\n" +
                "error.nexus.client.nexus.user.pass.failed=nexus用户名或密码错误\n" +
                "error.nexus.client.nexus.role.pri.not.assigned=用户权限不足，没有该操作的权限\n" +
                "error.nexus.client.nexus.server.failed=访问nexus服务失败，请检查服务是否正常\n" +
                "error.nexus.client.resource.not.exist=对应资源已不存在\n" +
                "error.nexus.client.not.update.asset=包上传错误： 该仓库，不允许去更新已有包\n" +
                "error.nexus.api.is.error=调用nexus服务接口失败，返回状态码：{0}\n" +
                "\n" +
                "\n" +
                "error.nexus.not.select.file=请选择文件上传\n" +
                "error.nexus.file.type=文件类型错误\n" +
                "error.nexus.server.config.multi=nexus服务生效的配置有多个，请联系管理员检查\n" +
                "error.nexus.server.info.not.config=没有可用的nexus服务配置\n" +
                "error.nexus.repo.name.suffix=仓库名： 仅允许英文、数字、下划线、中划线、点(.)组成，且后缀名限制为以下数据：{0}\n" +
                "error.nexus.repo.name.valid=仓库名： 仅允许英文、数字、下划线、中划线、点(.)组成\n" +
                "error.nexus.allow.anonymous.not.empty=是否允许匿名访问不能为空\n" +
                "error.nexus.version.policy.not.empty=仓库策略不能为空\n" +
                "error.nexus.write.policy.not.empty=版本策略不能为空\n" +
                "error.nexus.remote.url.not.empty=远程仓库地址不能为空\n" +
                "error.nexus.remote.user.password.not.empty=填写了远程仓库账号，必须填写账号密码\n" +
                "error.nexus.repo.member.not.empty=仓库组成员不能为空\n" +
                "error.nexus.maven.repo.type.error=仓库类型错误\n" +
                "error.nexus.maven.repo.not.update.other.pro=不能更改其它项目的仓库\n" +
                "error.nexus.related.repo.not.admin=请填写管理员admin之外的用户\n" +
                "error.nexus.repo.list.not.empty=仓库列表不能为空\n" +
                "error.nexus.user.and.password.error=用户名或密码错误\n" +
                "error.nexus.repo.related.not.exist=关联仓库不存在：{0}\n" +
                "error.nexus.repo.related.type.error=仓库类型错误，{0}仓库不是{1}类型的仓库\n" +
                "error.nexus.repo.already.related=仓库{0}已被关联，不能再关联\n" +
                "error.nexus.repo.related.error=以下仓库关联失败：{0}\n" +
                "error.nexus.repo.related.default.user.is.null=关联仓库：{0}，默认发布用户为空\n" +
                "error.nexus.url.error=地址填写有误，如：http://www.example.com\n" +
                "error.nexus.not.delete.component=不能删除该仓库下的数据（只能删除自建或已关联仓库下的包）\n" +
                "error.nexus.new.password.not.null=新密码不能为空\n" +
                "error.nexus.old.password.not.null=旧密码不能为空\n" +
                "error.nexus.not.change.other.repo.password=对应仓库不在当前项目下，不能更改管理用户密码\n" +
                "error.nexus.old.password.error=原密码填写错误\n" +
                "error.nexus.default.role.is.null={0}仓库对应关联角色不存在\n" +
                "error.nexus.auth.repository.id.is.not.null=只能同时分配同一仓库下的权限\n" +
                "error.nexus.auth.already.exist=权限已存在，请勿重复分配: {0}\n" +
                "error.nexus.user.not.exist=nexus对应用户已不存在\n" +
                "error.nexus.user.forbidden=用户权限不足，没有该操作的权限\n" +
                "error.nexus.auth.owner.not.delete=制品库创建者的权限信息不允许删除\n" +
                "error.nexus.auth.owner.not.update=制品库创建者的权限信息不允许更新\n" +
                "error.nexus.group.not.delete.component=仓库组不允许删除包信息\n" +
                "error.nexus.repo.is.enable=仓库已经启用，不能做多次操作\n" +
                "error.nexus.repo.is.disable=仓库已经失效，不能做多次操作\n" +
                "error.nexus.param.error=参数错误\n" +
                "error.nexus.input.admin.user=请填写admin管理员用户\n" +
                "error.nexus.user.not.permissions=输入的管理用户，权限不足：请输入管理员用户或包含管理员角色的用户\n" +
                "error.nexus.anonymous.user.not.exist=匿名用户不存在\n" +
                "error.nexus.anonymous.role.user.not.exist=匿名用户对应角色不存在\n" +
                "error.nexus.new.password=新密码填写错误\n" +
                "error.nexus.enable.anonymous.flag.is.no.not.set=当前项目，启用的nexus服务，未开启匿名访问控制。不能设置为：不允许匿名访问。(请在自定义nexus服务中查看)\n" +
                "error.nexus.repo.is.rea.only.not.delete=仓库是只读的，不允许删除包\n" +
                "error.nexus.repo.is.rea.only.not.upload=仓库是只读的，不允许上传包\n" +
                "error.nexus.server.version=nexus服务版本需要3.21.0及其以上\n" +
                "error.url.is.error.server.version=请检查输入地址是否正确\n" +
                "error.nexus.count.is.null.not.delete=该仓库是hosted仓库，请先删除仓库下的组件包后，再删除仓库\n" +
                "\n" +
                "#harbor.project\n" +
                "error.harbor.project.exist=镜像仓库已存在，请勿重复创建\n" +
                "error.harbor.project.get.harborId=镜像仓库已创建，但是获取仓库ID失败\n" +
                "error.harbor.project.not.exist=镜像仓库不存在，请检查\n" +
                "error.harbor.project.StorageUnit.empty=存储容量单位为空，请选择\n" +
                "error.harbor.project.flag.value.not.in=标记字段值必须在区间中['true','false'],请检查：{0} {1}\n" +
                "error.harbor.project.StorageUnit.value.not.in=存储容量单位字段值必须在区间中['KB',''MB','GB','TB'],请检查：{0} {1}\n" +
                "error.harbor.project.Severity.value.not.in=危害级别字段值必须在区间中 ['low','medium','high','creatical'],请检查：{0} {1}\n" +
                "error.harbor.image.repoName.empty=名称[repoName]为空\n" +
                "error.harbor.auth.already.exist=权限已存在，请勿重复分配\n" +
                "error.harbor.organization.no.project=组织下无镜像仓库\n" +
                "error.harbor.auth.find.harborAuthId=用户在Harbor系统中已经有权限，不能再次分配。请联系管理员\n" +
                "error.harbor.auth.owner.not.delete=制品库创建者的权限信息不允许删除！\n" +
                "error.harbor.auth.not.projectAdmin=当前用户非\"仓库管理员角色\"，不允许操作！\n" +
                "error.harbor.auth.null=当前用户无权限角色，不允许操作！\n" +
                "error.harbor.auth.owner.not.update=制品库创建者的权限信息不允许更新！\n" +
                "error.harbor.auth.update.last.projectAdmin=权限列表至少需要一个仓库管理员，暂不允许更新！\n" +
                "error.harbor.auth.delete.last.projectAdmin=权限列表至少需要一个仓库管理员，暂不允许删除！\n" +
                "\n" +
                "#feign\n" +
                "error.feign.user.batch.select=批量查询用户信息报错\n" +
                "error.feign.user.select=查询用户信息报错\n" +
                "error.feign.user.selectUserByProjectId=根据项目ID查询团队成员报错\n" +
                "error.feign.project.select=查询项目信息报错\n" +
                "error.feign.project.select.empty=base-service中查询项目信息为空\n" +
                "error.feign.user.select.empty=base-service中查询用户信息为空\n" +
                "error.feign.file.delete=文件删除报错\n" +
                "error.feign.project.owner=查询项目下项目所有者信息报错\n" +
                "error.feign.appService.page=分页查询应用服务报错\n" +
                "error.feign.appService.list.active=查询启用的应用服务报错\n" +
                "error.feign.appService.list.ids=根据ID批量查询应用服务报错\n" +
                "error.feign.appService.list.not.match=批量查询应用服务的结果与参数ids不匹配\n" +
                "\n" +
                "#harbor.statusCode\n" +
                "error.delete.project.412=当前镜像仓库中存在镜像，暂时不允许删除\n" +
                "error.harbor.image.tag.copy.412=当前项目\"开启了漏洞扫描\"或者\"阻止潜在漏洞镜像\",但是没有配置漏洞扫描器，故不能复制镜像版本到其他仓库.若仍然需要复制镜像版本，请修改仓库配置\n" +
                "\n" +
                "#harbor.robot\n" +
                "error.harbor.robot.repository.select=查找镜像仓库失败，请检查猪齿鱼项目ID {0}\n" +
                "error.harbor.robot.action.wrong=机器人账户的action设置错误\n" +
                "error.harbor.robot.name.empty=创建机器人账户的名称参数为空，请检查猪齿鱼项目ID {0}\n" +
                "error.harbor.robot.projectId.empty=创建机器人账户的猪齿鱼项目ID参数为空，请检查猪齿鱼项目ID {0}\n" +
                "error.harbor.robot.name.different=系统中机器人账户名称与harbor不同\n" +
                "error.harbor.robot.enabled.different=harbor中机器人账户已禁用\n" +
                "error.harbor.robot.endDate.different=系统中机器人账户过期时间与harbor不同\n" +
                "error.harbor.robot.harborRobotId.empty=harbor机器人账户ID为空\n" +
                "error.harbor.robot.delete.expired=删除过期机器人账户失败\n" +
                "error.harbor.robot.not.exist=机器人账户不存在\n" +
                "\n" +
                "#harbor.customRepo\n" +
                "error.harbor.custom.repo.url=自定义仓库URL地址错误\n" +
                "error.harbor.custom.repo.current.user=自定义仓库用户名或密码错误\n" +
                "error.harbor.custom.repo.email.not.equal=输入邮箱与自定义仓库不同\n" +
                "error.harbor.custom.repo.no.match.project=自定仓库中无匹配项目\n" +
                "error.harbor.custom.repo.not.exist=自定义仓库不存在\n" +
                "error.harbor.custom.repo.repoName.empty=自定义仓库名称为空\n" +
                "error.harbor.custom.repo.toRelate.appService.not.select=存在错误的待关联应用服务\n" +
                "error.harbor.repo.service.relation.not.exist=此关联关系不存在\n" +
                "error.harbor.repo.service.relation.exist=关联关系已存在\n" +
                "error.harbor.repo.service.relation.duplicate=存在重复的关联关系\n" +
                "error.harbor.custom.repo.share.exist=已存在项目下共享的自定义仓库\n" +
                "error.repo.already.exists.under.the.project=仓库名字在项目下已经存在\n" +
                "error.harbor.custom.repo.share.duplicate=存在多个项目下共享的自定义仓库\n" +
                "error.harbor.custom.repo.not.enabled=自定义仓库未启用\n" +
                "error.harbor.config.repoType=harbor仓库类型错误\n" +
                "\n" +
                "error.user.newPwd.same.oldPwd=新密码不能和旧密码一致\n" +
                "error.user.pwd.pattern=密码长度最少八个字符，至少一个大写字母，一个小写字母和一个数字\n" +
                "error.user.not.current.user=非当前用户，不允许操作！\n" +
                "\n" +
                "#xml\n" +
                "error.xml.invalid.pom=pom.xml文件格式错误\n" +
                "error.xml.pom.tag.miss=pom.xml缺少必要标签{0}\n" +
                "\n" +
                "#harbor.api\n" +
                "error.harbor.api.create.project.name.valid=项目名称由小写字符、数字和._-组成且至少1个字符并以字符或者数字开头.\n" +
                "error.harbor.registerOrg.info.empty=注册组织时，报文信息为空！\n" +
                "error.c7n.repo.not.exist=仓库信息不存在！\n" +
                "error.parse.repo.response=测试连接失败\n" +
                "error.image.tag.name=tag名不能为空\n" +
                "error.repo.url=仓库地址无效\n";
        //去掉中文，等号换成";
        msg.split("\\(");
        String[] split = msg.split("\n");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("=");
            sb.append("\"").append(split1[0]).append("\"").append(";").append("\n");
        }
        String s = sb.toString();
        String replace = s.replace("error", "rdupm");
        System.out.println(replace);
        String replace1 = replace.replace(".", "_");
        String replace2 = replace1.replace("\"", "").replace(";", "");
        System.out.println(replace);

    }
}
