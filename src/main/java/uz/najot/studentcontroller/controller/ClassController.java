package uz.najot.studentcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.najot.studentcontroller.message.ResMessage;
import uz.najot.studentcontroller.model.Classes;
import uz.najot.studentcontroller.service.ClassService;

import javax.validation.Valid;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @GetMapping
    public ResMessage getAll(){
        return classService.findAll();
    }

    @PostMapping
    public ResMessage saveClass(@Valid @RequestBody Classes classes){
        return classService.save(classes);
    }

    @PutMapping()
    public ResMessage updateClass(@Valid @RequestBody Classes classes){
        return classService.update(classes);
    }

    @DeleteMapping
    public ResMessage deleteClass(@RequestParam Integer id){
        return classService.delete(id);
    }

}
