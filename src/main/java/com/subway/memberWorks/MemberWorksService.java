package com.subway.memberWorks;

import java.util.List;
import java.util.Map;

import com.subway.member.Member;
import com.subway.service.app.BaseService;
import com.subway.utils.ConstantUtils;
import com.subway.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * 会员作品涓氬姟绫?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberWorksService extends BaseService {


    @Autowired
    MemberWorksRepository memberWorksRepository;

    /**
     * @return
     */
    public List<MemberWorks> findAll() {
        return memberWorksRepository.findAll();
    }


    /**
     * @param pageable
     * @return
     */
    public Page<MemberWorks> findAll(Pageable pageable) {
        return memberWorksRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return
     */
    public MemberWorks findById(Long id) {
        return memberWorksRepository.getOne(id);
    }


    /**
     * @param recordId 记录id
     * @param filePath 文件的路径
     */
    public void writeUploadLog(Long recordId, String filePath) {
        MemberWorks memberWorks = memberWorksRepository.getOne(recordId);
        memberWorks.setPhotoUrl(filePath);
        memberWorksRepository.save(memberWorks);
    }

}
