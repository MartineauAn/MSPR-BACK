package fr.epsi.b33.MSPR.repo;

import fr.epsi.b33.MSPR.bo.Asset;
import fr.epsi.b33.MSPR.bo.PlantPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, String> {
}
