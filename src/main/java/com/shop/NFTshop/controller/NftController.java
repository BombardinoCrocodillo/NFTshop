package com.shop.NFTshop.controller;

import com.shop.NFTshop.persistence.model.Nft;
import com.shop.NFTshop.persistence.repository.NftRepository;
import com.shop.NFTshop.service.NftService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class NftController {

    private final NftService nftService;
    private final NftRepository nftRepository;

    public NftController(NftService nftService, NftRepository nftRepository) {
        this.nftService = nftService;
        this.nftRepository = nftRepository;
    }

    @GetMapping("/start")
    public void startApplication() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== NFT Shop Console ===");
            System.out.println("1. Add NFT to market");
            System.out.println("2. Remove NFT from market");
            System.out.println("3. Buy NFT");
            System.out.println("4. Show all NFTs");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNft(scanner);
                    break;
                case 2:
                    removeNft(scanner);
                    break;
                case 3:
                    buyNft(scanner);
                    break;
                case 4:
                    showAllNfts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addNft(Scanner scanner) {
        System.out.print("Enter NFT name: ");
        String name = scanner.nextLine();
        System.out.print("Enter NFT description: ");
        String description = scanner.nextLine();
        System.out.print("Enter NFT price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Nft nft = nftService.addNftToMarket(name, description, price);
        System.out.println("NFT added successfully: " + nft.getName());
    }

    private void removeNft(Scanner scanner) {
        System.out.print("Enter NFT ID to remove: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        nftService.removeNftFromMarket(id);
        System.out.println("NFT removed successfully.");
    }

    private void buyNft(Scanner scanner) {
        System.out.print("Enter NFT ID to buy: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        try {
            nftService.buyNft(id, username);
            System.out.println("NFT purchased successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showAllNfts() {
        System.out.println("\n=== Available NFTs ===");
        nftRepository.findAll().forEach(nft -> {
            System.out.println("ID: " + nft.getId());
            System.out.println("Name: " + nft.getName());
            System.out.println("Description: " + nft.getDescription());
            System.out.println("Price: " + nft.getPrice());
            System.out.println("Owner: " + (nft.getOwner() != null ? nft.getOwner().getUsername() : "None"));
            System.out.println("-----------------------");
        });
    }
}