package com.huawei.it.hwdata.controller.web;

import com.huawei.it.hwdata.vo.FileModel;
import com.huawei.it.hwdata.vo.FileVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;

@Controller
@RequestMapping("/upload")
public class UploadController {
    //通过Spring的autowired注解获取spring默认配置的request

    /***
     * 保存文件
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file, String path) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String savePath = path + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(savePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @RequestMapping("/filesUpload")
    public String filesUpload(@RequestParam("files") MultipartFile[] files) {
        String path = "E:/upload/";
        //判断file数组不能为空并且长度大于0
        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                //保存文件
                saveFile(file, path);
            }
        }
        // 重定向
        return "redirect:/list.html";
    }

    @RequestMapping("/goFile")
    public String goFilesUpload() {

        return "/WEB-INF/jsp/upload.jsp";

    }

    public String test(MultipartFile upload) throws Exception {
        byte[] uploadBytes = upload.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(uploadBytes);
        String hashString = new BigInteger(1, digest).toString(16);
        return hashString.toUpperCase();
    }

    @RequestMapping("/goFileTest")
    public String goFilesUploadTest() {

        return "/WEB-INF/jsp/test.jsp";

    }



    @RequestMapping("/saveFileTest")
    public String saveFilesUploadTestString(FileModel model) {


        System.out.println("--------------------"+model.getFileList().size());

        return "";
    }





    }