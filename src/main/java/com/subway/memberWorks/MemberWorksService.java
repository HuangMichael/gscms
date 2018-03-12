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
     * @param file ��ý���ļ�
     * @return �ϴ��ļ�
     */
    @Transactional
    public Boolean upload(MultipartFile file, String tempDir, Long recordId) {
        String realDir = ConstantUtils.CONTEXT_PATH + "/upload/" + tempDir + "/";//��Ŀ��ý���ŵ��ļ��У�����ʱ�����Ψһ��ʶ��ʱ���ϴ������е��ļ�
        if (!UploadUtil.createDirectory(realDir)) {//Ŀ¼����ʧ���򷵻�null��Ŀ¼���ڻ��ߴ����ɹ��ͼ���ִ��
            return null;
        }
        String fileName = file.getOriginalFilename().replace(" ", "");//�ļ�����ȥ���ļ����еĿո�
        String filePath = realDir + "\\" + fileName;//�����ļ�·��
        boolean result = UploadUtil.uploadFile(file, filePath);//�ϴ��ļ���Tomcat����Ϊ��ʱ�ļ�;
        String relativePath = "upload/" + tempDir + "/" + fileName;
        writeUploadLog(relativePath, recordId);
        return result;

    }


    /**
     * @param recordId ��¼id
     * @param filePath �ļ���·��
     */
    public void writeUploadLog(String filePath, Long recordId) {
        MemberWorks memberWorks = memberWorksRepository.getOne(recordId);
        memberWorks.setPhotoUrl(filePath);
        memberWorksRepository.save(memberWorks);
    }
}
