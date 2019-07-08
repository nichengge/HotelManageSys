package demo.ServerImpl;
import demo.Model.Administrator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("AdministratorService")
@Transactional
@SuppressWarnings("all")
public class AdministratorService extends BaseService{
    int ans=0;

    //增

    //删

    //查

    //管理员登录
    public int adminlogin(Administrator administrator){
        System.out.println("正在管理员登录验证..from AdminiService");
        Administrator administrator1 = null;
        try {
            System.out.println("username:"+administrator.getUsername()+"  password:"+administrator.getPassword());
            administrator1 = administratorMapper.adminconfirm(administrator);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(administrator1!=null){
            System.out.println("验证成功");
            ans=1;
        }
        else {
            System.out.println("验证失败");
            ans=0;
        }
        return ans;
    }

    //改

}
