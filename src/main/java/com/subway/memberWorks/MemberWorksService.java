package com.subway.memberWorks;

import java.util.List;
import java.util.Map;

import com.subway.columnsContent.ColumnsContent;
import com.subway.member.Member;
import com.subway.object.ReturnObject;
import com.subway.service.app.BaseService;
import com.subway.service.commonData.CommonDataService;
import com.subway.utils.ConstantUtils;
import com.subway.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * ��Ա��Ʒ业务�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberWorksService extends BaseService {


    @Autowired
    MemberWorksRepository memberWorksRepository;

    @Autowired
    CommonDataService commonDataService;

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
     * @param id ��¼id
     * @return ����idɾ����¼
     */
    public ReturnObject delete(Long id) {
        memberWorksRepository.delete(id);
        MemberWorks memberWorks = memberWorksRepository.getOne(id);
        return commonDataService.getReturnType(memberWorks == null, "��¼ɾ���ɹ�", "��¼ɾ��ʧ��");
    }

    /**
     * @param recordId ��¼id
     * @param filePath �ļ���·��
     */
    @Override
    public void writeUploadLog(String filePath, Long recordId) {
        MemberWorks memberWorks = memberWorksRepository.getOne(recordId);
        memberWorks.setPhotoUrl(filePath);
        memberWorksRepository.save(memberWorks);
    }
}
