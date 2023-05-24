-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Bulan Mei 2023 pada 06.38
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan_motor`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_motor`
--

CREATE TABLE `data_motor` (
  `id_motor` varchar(10) NOT NULL,
  `merk_motor` varchar(50) NOT NULL,
  `jenis_motor` varchar(50) NOT NULL,
  `model_motor` varchar(50) NOT NULL,
  `tahun_beli` varchar(5) NOT NULL,
  `jarak_tempuh` varchar(20) NOT NULL,
  `harga_jual` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_motor`
--

INSERT INTO `data_motor` (`id_motor`, `merk_motor`, `jenis_motor`, `model_motor`, `tahun_beli`, `jarak_tempuh`, `harga_jual`) VALUES
('MT002', 'Yamaha', 'Sport', 'Vixion', '2021', '20000 km', '23000000'),
('MT003', 'Honda', 'Matic', 'Vario', '2022', '12000 km', '15000000'),
('MT005', 'Suzuki', 'Sport', 'Satria F150', '2016', '12000 km', '13000000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `NoFaktur` varchar(20) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `id_user` varchar(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `total_harga` decimal(10,0) NOT NULL,
  `pembayaran` varchar(30) NOT NULL,
  `delivery` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`NoFaktur`, `tanggal`, `id_user`, `username`, `total_harga`, `pembayaran`, `delivery`) VALUES
('TR0001', '20-05-2023', '3', 'alung', '11000000', 'Cash On Delivery', 'Ambil di Dealer'),
('TR0002', '20-05-2023', '2', 'prima', '15000000', 'Transfer Bank', 'Antar ke Alamat Rumah'),
('TR0003', '23-05-2023', '2', 'prima', '28000000', 'Transfer Bank', 'Ambil di Dealer');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian_rinci`
--

CREATE TABLE `pembelian_rinci` (
  `NoFaktur` varchar(20) NOT NULL,
  `id_motor` varchar(10) NOT NULL,
  `merk_motor` varchar(50) NOT NULL,
  `model_motor` varchar(50) NOT NULL,
  `harga` decimal(10,0) NOT NULL,
  `total` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembelian_rinci`
--

INSERT INTO `pembelian_rinci` (`NoFaktur`, `id_motor`, `merk_motor`, `model_motor`, `harga`, `total`) VALUES
('TR0001', 'MT004', 'Honda', 'Beat', '11000000', '11000000'),
('TR0002', 'MT003', 'Honda', 'Vario', '15000000', '15000000'),
('TR0003', 'MT005', 'Suzuki', 'Satria F150', '13000000', '13000000'),
('TR0003', 'MT003', 'Honda', 'Vario', '15000000', '15000000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `lvl` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `lvl`, `email`, `alamat`, `no_hp`, `jenis_kelamin`) VALUES
(1, 'ahlul', '123', 'admin', '', '', '', ''),
(2, 'prima', '123', 'customer', 'prima@gmail.com', 'bantul', '08234234235', 'Pria'),
(3, 'alung', '123', 'customer', '', '', '', ''),
(4, 'rebecca', '123', 'customer', '', '', '', ''),
(5, 'rico', '123', 'customer', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data_motor`
--
ALTER TABLE `data_motor`
  ADD PRIMARY KEY (`id_motor`);

--
-- Indeks untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`NoFaktur`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
