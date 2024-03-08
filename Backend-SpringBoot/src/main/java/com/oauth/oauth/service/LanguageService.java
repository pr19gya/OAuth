package com.oauth.oauth.service;

import com.oauth.oauth.dao.FrameworksDAO;
import com.oauth.oauth.dao.LanguagesDAO;
import com.oauth.oauth.dao.StringObjectDAO;
import com.oauth.oauth.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguagesDAO languagesDAO;
    @Autowired
    FrameworksDAO frameworksDAO;
    @Autowired
    StringObjectDAO stringObjectDAO;

    public boolean addLanguagesList(List<Language> languageList) {

      try {
          for (Language language:languageList){
              languagesDAO.save(language);
          }
          return true;
      }
      catch (Exception e){
          e.printStackTrace();
      }
      return false;
    }

    public boolean addLanguage(Language language) {

        try {
            languagesDAO.save(language);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Language> getAllLanguages(){
        return languagesDAO.findAll();
    }

    public Language getLanguageById(String id){
        return languagesDAO.findById(id).get();
    }

//    @Autowired
//    ModelMapper modelMapper;

}
