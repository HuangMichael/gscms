package com.subway.member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.subway.domain.user.User;
import com.subway.object.ReturnObject;
import com.subway.service.app.BaseService;
import com.subway.service.commonData.CommonDataService;
import com.subway.utils.ConstantUtils;
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
     * @param recordId 记录id
     * @param filePath 文件的路径
     */
    public void writeUploadLog(String filePath, Long recordId) {
        super.writeUploadLog(filePath, recordId);
        Member member = memberRepository.getOne(recordId);
        member.setPhotoUrl(filePath);
        member.setHasPhoto(ConstantUtils.STATUS_YES);
        memberRepository.save(member);
    }
}
