### [mariadb 포트 확인]
```sh
SHOW GLOBAL VARIABLES LIKE 'PORT';
```

### [mariadb 포트 변경]
```sh
vim /etc/mysql/mariadb.conf.d/50-server.cnf
```
<img width="428" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/da5a01c2-e67b-4124-8d13-9da03ba8d00a">

- default 포트는 3306이고, 주석 풀어준 후, 포트 변경해주기
- 저장 후, 아래 명령어 실행하여 적용 
```sh
sudo systemctl restart mariadb
```
- 변경 후
<img width="374" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/3cf0f16e-ebef-4470-b028-0a31fc389b33">

### [mariadb 실행/중지]
- mariadb 실행
```sh
systemctl start mariadb
```
- mariadb 중지
```sh
systemctl stop mariadb
```
- ubuntu 재시작시, mysql 자동으로 시작할 수 있도록 service를 등록
```sh
sudo systemctl enable mysql
```

