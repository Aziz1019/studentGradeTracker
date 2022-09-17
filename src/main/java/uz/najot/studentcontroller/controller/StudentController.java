package uz.najot.studentcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Students;
import uz.najot.studentcontroller.service.StudentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResMessage getAll(){
        return studentService.findAll();
    }
    @PostMapping
    public ResMessage studentSave(@Valid @RequestBody Students students){
        return studentService.save(students);
    }
    @GetMapping("{group_id}")
    public ResMessage getStudent(@PathVariable Integer group_id){
        return studentService.findByGroupId(group_id);
    }

    @PutMapping
    public ResMessage updateStudent(@Valid @RequestBody Students students){
        return studentService.update(students);
    }

    @DeleteMapping
    public ResMessage deleteStudent(@RequestParam Integer id){
        return studentService.delete(id);
    }
}
