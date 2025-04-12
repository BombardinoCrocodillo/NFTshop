package com.shop.NFTshop.service;

import com.shop.NFTshop.persistence.model.Nft;
import com.shop.NFTshop.persistence.repository.NftRepository;
import com.shop.NFTshop.persistence.model.User;
import com.shop.NFTshop.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NftService {

    private final NftRepository nftRepository;
    private final UserRepository userRepository;

    public NftService(NftRepository nftRepository, UserRepository userRepository) {
        this.nftRepository = nftRepository;
        this.userRepository = userRepository;
    }

    public Nft addNftToMarket(String name, String description, double price) {
        Nft nft = new Nft();
        nft.setName(name);
        nft.setDescription(description);
        nft.setPrice(price);
        return nftRepository.save(nft);
    }

    public void removeNftFromMarket(Long nftId) {
        nftRepository.deleteById(nftId);
    }

    public void buyNft(Long nftId, String buyerUsername) {
        Optional<Nft> optionalNft = nftRepository.findById(nftId);
        User buyer = userRepository.findByUsername(buyerUsername);

        if (optionalNft.isPresent() && buyer != null) {
            Nft nft = optionalNft.get();

            if (buyer.getBalance() >= nft.getPrice()) {
                buyer.setBalance(buyer.getBalance() - nft.getPrice());
                nft.setOwner(buyer);
                userRepository.save(buyer);
                nftRepository.save(nft);
            } else {
                throw new RuntimeException("Insufficient balance");
            }
        } else {
            throw new RuntimeException("NFT or buyer not found");
        }
    }
}
