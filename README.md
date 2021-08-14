# APLIKASI INVOICE MANAGEMENT MENGGUNAKAN SPRING FRAMEWORK #

Aplikasi ini digunakan untuk mengelola invoice dan menyambung dengan berbagai macam metode pembayaran masa kini, 
antara lain :

    * Virtual Account Bank
        - Bank BNI
        - Bank CIMB
        - Bank BSI

    * e-wallet
        - OVO
        - Go-Pay

    * QR payment
        - QRIS


1. Membuat repository di github / gitlab

2. Membuat project di start.spring.io
    Dependency
        - Sping Web
        - DBMS (mysql / postgresql)
        - Flyaway Migration
        - Spring Data JPA
        - Lombok
        - Thymleaf

3. Mengekstrak project yang digenerate

4. Membuild project dengan mengabaikan test : mvn clean package -DskipTests

5. push ke github

# Cara Setup Database (Menggunakan Docker dan postgreSql) #

7. Menjalankan postgreSql di Docker
   *password menggunakan random string dari random.org/strings
   *tag image jangan pake default(latest)
    * -v volume mapping simpan ke directory project, tapi tidak usah diupload ke repository
...   
$ docker run --rm \
      --name invoice-db \
      -e POSTGRES_DB=invoicedb \
      -e POSTGRES_USER=invoice \
      -e POSTGRES_PASSWORD=L5eACAebPZzrYbRZdUfm \
      -e PGDATA=/var/lib/postgresql/data/pgdata \
      -v "$PWD/invoicedb:/var/lib/postgresql/data" \
      -p 5432:5432 \
    postgres:13
...
    * ketik command diatas kedalam teminal.

    * daftarkan postgresql kedalam path environment variable
      
    * cek koneksi database dengan command : psql -h 127.0.0.1 -U invoice invoicedb    
    // jika terdapat ERROR (psql: error: FATAL:  password authentication failed for user "invoice")
      gunakan perintah : docker exec -ti invoice-db psql -h 127.0.0.1 -U invoice invoicedb
      
    * pastikan tidak server database tidak bentrok
      
8. Mengisi application.properties
... 
   spring.datasource.url=jdbc:postgresql://localhost/invoicedb
   spring.datasource.username=invoice
   spring.datasource.password=L5eACAebPZzrYbRZdUfm
   
   spring.jpa.hibernate.ddl-auto=validate
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
...
   
9. membuat db.migration 
    # Penamaan versi memakai calver (Callender Versioning) sehingga menjadi V20210801__Skema_Awal.sql

    * Buat terlebih template terlebih dahulu untuk testing migrasi database
    ....
      CREATE TABLE payment_provider (
      id VARCHAR (36),
      PRIMARY KEY (id)
      );

    CREATE TABLE invoice_type (
    id VARCHAR (36),
    PRIMARY KEY (id)
    );
    
    CREATE TABLE invoice (
    id VARCHAR (36),
    PRIMARY KEY (id)
    );
    
    CREATE TABLE virtual_account (
    id VARCHAR (36),
    PRIMARY KEY (id)
    );
    
    CREATE TABLE payment (
    id VARCHAR (36),
    PRIMARY KEY (id)
    );
    ....
   
    * Jalankan project : mvn clean spring-boot:run
   

      
    




L5eACAebPZzrYbRZdUfm