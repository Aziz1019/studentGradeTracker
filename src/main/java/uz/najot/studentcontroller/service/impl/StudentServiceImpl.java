package uz.najot.studentcontroller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Students;
import uz.najot.studentcontroller.service.StudentService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public ResMessage findAll() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from students");
        return ResMessage.getSuccess(maps);
    }

    @Override
    public ResMessage save(Students students) {
        String a = "insert into students (first_name, last_name, phone, group_id) values (?,?,?,?)";
        int update = jdbcTemplate.update(a,
                students.getFirstName(), students.getLastName(), students.getPhone(), students.getGroupId());
        return update > 0 ? ResMessage.getSuccess() : new ResMessage(101, "Not Saved", null);
    }

    @Override
    public ResMessage update(Students students) {
        String a = "update students set first_name = ?, last_name = ?, phone = ?, group_id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(a, students.getFirstName(), students.getLastName(), students.getPhone(), students.getGroupId());
        return ResMessage.getSuccess(maps);
    }


    @Override
    public ResMessage delete(Integer id) {
        int update = jdbcTemplate.update("delete from students where id = ?", id);
        return update > 0 ? ResMessage.getSuccess() : new ResMessage(101, "Not Updated", null);
    }

    @Override
    public ResMessage findByGroupId(Integer id) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from students where group_id = ? ", id);
        return new ResMessage(0, "ok", maps);
    }
}
