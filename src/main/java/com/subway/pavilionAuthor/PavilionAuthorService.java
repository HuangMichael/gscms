package com.subway.pavilionAuthor;

import java.util.List;
import java.util.Map;

import com.subway.member.Member;
import com.subway.memberWorks.MemberWorks;
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
 * չ��������Ϣҵ����
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class PavilionAuthorService extends BaseService {


    @Autowired
    PavilionAuthorRepository pavilionAuthorRepository;


    @Autowired
    CommonDataService commonDataService;

    /**
     * @return
     */
    public List<PavilionAuthor> findAll() {
        return pavilionAuthorRepository.findAll();
    }


    /**
     * @param pageable
     * @return
     */
    public Page<PavilionAuthor> findAll(Pageable pageable) {
        return pavilionAuthorRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return
     */
    public PavilionAuthor findById(Long id) {
        return pavilionAuthorRepository.getOne(id);
    }


    /**
     * @param id ��¼id
     * @return ����idɾ����¼
     */
    public ReturnObject delete(Long id) {
        pavilionAuthorRepository.delete(id);
        PavilionAuthor pavilionAuthor = pavilionAuthorRepository.getOne(id);
        return commonDataService.getReturnType(pavilionAuthor == null, "��¼ɾ���ɹ�", "��¼ɾ��ʧ��");
    }


    /**
     * @param file ��ý���ļ�
     * @return �ϴ��ļ�
     */
    @Transactional
    public Boolean upload(MultipartFile file, String tempDir, Long recordId) {
        String realDir = ConstantUtils.CONTEXT_PATH + "/upload/" + tempDir + "/";
        //��Ŀ��ý���ŵ��ļ��У�����ʱ�����Ψһ��ʶ��ʱ���ϴ������е��ļ�
        if (!UploadUtil.createDirectory(realDir)) {
            //Ŀ¼����ʧ���򷵻�null��Ŀ¼���ڻ��ߴ����ɹ��ͼ���ִ��
            return null;
        }
        String fileName = file.getOriginalFilename().replace(" ", "");//�ļ�����ȥ���ļ����еĿո�
        String filePath = realDir + "\\" + fileName;//�����ļ�·��
        boolean result = UploadUtil.uploadFile(file, filePath);//�ϴ��ļ���Tomcat����Ϊ��ʱ�ļ�;
        String relativePath = "/upload/" + tempDir + "/" + fileName;
        writeUploadLog(recordId, relativePath);
        return result;

    }


    /**
     * @param recordId ��¼id
     * @param filePath �ļ���·��
     */
    public void writeUploadLog(Long recordId, String filePath) {
        PavilionAuthor pavilionAuthor = pavilionAuthorRepository.getOne(recordId);
        pavilionAuthor.setPhotoUrl(filePath);
        pavilionAuthor.setHasPhoto(ConstantUtils.STATUS_YES);
        pavilionAuthorRepository.save(pavilionAuthor);
    }

}
