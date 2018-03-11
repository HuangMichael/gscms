package com.subway.member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.subway.domain.user.User;
import com.subway.object.ReturnObject;
import com.subway.service.app.BaseService;
import com.subway.service.commonData.CommonDataService;
import com.subway.utils.SessionUtil;
import com.subway.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 会员信息业务类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberService extends BaseService {


    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CommonDataService commonDataService;

    /**
     * @return
     */
    public List<Member> findAll() {
        return memberRepository.findAll();
    }


    /**
     * @param pageable
     * @return
     */
    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return
     */
    public Member findById(Long id) {
        return memberRepository.getOne(id);
    }


    /**
     * @param id id
     * @return 根据id删除对象
     */
    public ReturnObject delete(Long id) {
        memberRepository.delete(id);
        Member member = memberRepository.getOne(id);
        return commonDataService.getReturnType(member == null, "记录删除成功", "记录删除失败");
    }


    /**
     * @param file    多媒体文件
     * @param request 请求
     * @return 上传文件
     */
    @Transactional
    public Boolean upload(MultipartFile file, HttpServletRequest request) {
        String realDir = "E:/dev/gscms/src/main/webapp/upload/member/";//项目多媒体存放的文件夹，加上时间戳来唯一标识该时间上传的所有的文件
        if (!UploadUtil.createDirectory(realDir)) {//目录创建失败则返回null，目录存在或者创建成功就继续执行
            return null;
        }
        String fileName = file.getOriginalFilename().replace(" ", "");//文件名，去掉文件名中的空格
        String filePath = realDir + "\\" + fileName;//绝对文件路径
        return UploadUtil.uploadFile(file, filePath);//上传文件到Tomcat，作为临时文件;

    }

}
