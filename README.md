# 🎨 NFT Shop - Магазин цифровых активов
![NFT Logo](https://postimg.cc/nXLnjs3c) <!-- Добавьте ссылку на ваш логотип -->

**NFT Shop** — это простое и удобное приложение для управления цифровыми активами (NFT). Вы можете добавлять, удалять и покупать NFT через консольный интерфейс. Проект создан с использованием Spring Boot, H2 базы данных и Liquibase для миграций.

---

## 📋 Содержание

1. [Описание проекта](#описание-проекта)
2. [Технологии](#технологии)
3. [Установка и запуск](#установка-и-запуск)
4. [Использование](#использование)
5. [API Endpoints](#api-endpoints)
6. [Известные проблемы](#известные-проблемы)
7. [Лицензия](#лицензия)

---

## 🌟 Описание проекта

Проект представляет собой магазин NFT, где пользователи могут:
- **Добавлять новые NFT** на рынок.
- **Удалять NFT** из рынка.
- **Покупать NFT**, используя баланс пользователя.
- **Просматривать все доступные NFT**.

Все операции выполняются через консольный интерфейс, что делает взаимодействие с приложением простым и интуитивно понятным.

---

## 💻 Технологии

Проект разработан с использованием следующих технологий:

- **Spring Boot**: Для создания REST API и управления зависимостями.
- **H2 Database**: Встроенная база данных для хранения данных о пользователях и NFT.
- **Liquibase**: Для управления миграциями базы данных.
- **JPA / Hibernate**: Для работы с базой данных через объектно-ориентированный подход.
- **Lombok**: Для уменьшения шаблонного кода.
- **Gradle**: Для сборки проекта.

---

## 🚀 Установка и запуск

### 1. Клонирование репозитория
Склонируйте репозиторий на свой компьютер:
```bash
git clone https://github.com/your-repository/nft-shop.git
cd nft-shop
