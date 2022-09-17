package uz.najot.studentcontroller.service;

import uz.najot.studentcontroller.message.ResMessage;

public interface BasicService<T> {
    ResMessage findAll();
    ResMessage save(T t);

    ResMessage update(T t);

    ResMessage delete(Integer id);

}
