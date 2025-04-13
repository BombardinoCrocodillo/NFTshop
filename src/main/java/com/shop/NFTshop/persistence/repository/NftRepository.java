package com.shop.NFTshop.persistence.repository;

import com.shop.NFTshop.persistence.model.Nft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NftRepository extends JpaRepository<Nft, Long> {
}