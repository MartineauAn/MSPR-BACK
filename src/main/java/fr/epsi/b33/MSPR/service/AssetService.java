package fr.epsi.b33.MSPR.service;

import fr.epsi.b33.MSPR.bo.Asset;
import fr.epsi.b33.MSPR.repo.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    public Asset PlantPostPhoto(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        return new Asset(fileName, file.getContentType(), file.getSize(), file.getBytes() );
    }

    public Asset getPhoto(String photo_uuid){
        Asset asset = null;
        Optional<Asset> photo = assetRepository.findById(photo_uuid);
        if (photo.isPresent()){
            asset = photo.get();
        }
        return asset;
    }
}
