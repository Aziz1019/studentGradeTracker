package uz.najot.studentcontroller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Classes;
import uz.najot.studentcontroller.service.ClassService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public ResMessage findAll() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from class_");
        return ResMessage.getSuccess(maps);
    }


    @Override
    public ResMessage save(Classes classes) {
        int update = jdbcTemplate.update("insert into class_(name) values (?)", classes.getName());
        if (update>0){
            return ResMessage.getSuccess();
        }
        return new ResMessage(101,"not created",null);
    }

    @Override
    public ResMessage update(Classes classes) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("update class_ set name = ? where id = ?", classes.getName(), classes.getId());
        return ResMessage.getSuccess(maps);
    }

    @Override
    public ResMessage delete(Integer id) {
        int update = jdbcTemplate.update("delete from class_ where id = ?", id);
        if (update>0){
            return ResMessage.getSuccess();
        }
        return new ResMessage(101,"Not Deleted",null);
    }

    @Override
    public ResMessage findById(Classes classes) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select id,name, created_date from groups where id = ?", classes.getId());
        return ResMessage.getSuccess(maps);
    }
}
