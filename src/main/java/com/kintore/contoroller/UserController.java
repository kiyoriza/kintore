package com.kintore.contoroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kintore.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/user/{id}")
    public UserDto getUserInfo(@PathVariable("id") String userId) {

        // 例として、ダミーデータを使用してUserDtoオブジェクトを作成して返す
        UserDto userDto = new UserDto();
//        userDto.setName("JohnDoe");
//        userDto.setMail("johndoe@example.com");
        return userDto;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserDto userDto) {
        // パスワードをSHA-256でハッシュ化
        // String hashedPassword = HashUtils.sha256(userDto.getPassword());
        // userDto.setPassword(hashedPassword);
        
        // ユーザー情報をデータベースに保存
        // userMapper.insertUser(userDto);

        return "User registered successfully!";
    }
    
    // @PostMapping("/signin")
    // public String signIn(@RequestBody UserDto user) {
        // パスワードをSHA-256でハッシュ化
        // String hashedPassword = HashUtils.sha256(user.getPassword());
        // user.setPassword(hashedPassword);
        
        // ユーザーログイン処理
        // UserDto loggedInUser = userMapper.getUserByUsernameAndPassword(user);
        
        // if (loggedInUser != null) {
        //     return "User logged in successfully!";
        // } else {
        //     return "Invalid username or password!";
        // }
    // }
    
}
