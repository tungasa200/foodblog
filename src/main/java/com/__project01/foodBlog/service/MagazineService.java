package com.__project01.foodBlog.service;

import com.__project01.foodBlog.dto.ImageFileDTO;
import com.__project01.foodBlog.dto.MagazineDTO;
import com.__project01.foodBlog.dto.MagazineFileDTO;
import com.__project01.foodBlog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MagazineService {
    private final BlogRepository blogRepository;


    public void save(MagazineDTO magazineDTO) throws IOException {
       if (magazineDTO.getVisualImage().get(0).isEmpty()){
           magazineDTO.setFileAttached(0);
           blogRepository.magazineSave(magazineDTO);
       }else {
           magazineDTO.setFileAttached(1);
           MagazineDTO saveMagazine = blogRepository.magazineSave(magazineDTO);
           for(MultipartFile magazineFile : magazineDTO.getVisualImage()){
               String originalFilename = magazineFile.getOriginalFilename();
               System.out.println("originalFilename = " + originalFilename);

               System.out.println(System.currentTimeMillis());
               String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
               System.out.println("storedFileName = " + storedFileName);

               MagazineFileDTO magazineFileDto = new MagazineFileDTO();
               magazineFileDto.setOriginalFileName(originalFilename);
               magazineFileDto.setStoredFileName(storedFileName);
               magazineFileDto.setArticleId(saveMagazine.getId());

               String savePath = "C:/development/intellij_community/spring_upload_files/" + storedFileName;
               magazineFile.transferTo(new File(savePath));
               blogRepository.saveMagazineFile(magazineFileDto);
           }
       }
   }

    public List<MagazineDTO> findAll() {
       return blogRepository.magazineFindAll();
    }

    public void updateHits(Long id) {
        blogRepository.magazineUpdateHits(id);
    }

    public MagazineDTO findById(Long id) {
        return blogRepository.magazineFindById(id);
    }

    public List<MagazineFileDTO> findFile(Long id) {
        return blogRepository.magazineFileFind(id);
    }

    public void update(MagazineDTO magazineDTO) {
        blogRepository.magazineUpdate(magazineDTO);
    }

    public void delete(Long id) {
        blogRepository.magazineDelete(id);
    }

    public List<MagazineDTO> findBest() {
        return blogRepository.magazineFindBest();
    }
}
