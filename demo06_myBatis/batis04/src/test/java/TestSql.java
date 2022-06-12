import com.shenlimin.mapper.TeacherMapper;
import com.shenlimin.pojo.Teacher;
import com.shenlimin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestSql {

    SqlSession session = MybatisUtils.getSqlSession();


    @Test
    public void testGetStudents() {
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }

    @Test
    public void testGetStudents2() {
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }
}
