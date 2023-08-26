# 'java-study' README.md

## Assignment01 - Chatting Program(java-study/HW1에 위치)
### 실행방법
```sh
$ git clone https://github.com/YeJi222/java-study.git
```

- 레포지토리 다운로드 후, 과제 실행 파일 위치로 이동 
- 과제 파일들 HW1 모듈에 위치 
```sh
$ cd java-study-main/HW1
```

- pom.xml 파일이 있는 곳에서 class 파일, jar 파일 등 생성
```sh
$ mvn clean package
```

#### [Server 실행]
- target이 생성되고 classes 디렉토리 위치로 이동
```sh
$ cd target/classes
```

- Chatting Server 실행 
```sh
$ java chatGUIserver.ChatServer
```
![image](https://github.com/YeJi222/java-study/assets/70511859/1c62522a-2d39-4c60-9915-cfd9e4caee72)

#### [Client 실행]
```sh
$ java chatGUIclient.ChatClientApp
```
![image](https://github.com/YeJi222/java-study/assets/70511859/c26a3b77-63bb-4b64-babf-49a0b72d4d10)

- 대화명에 채팅할 닉네임을 입력하고 엔터키를 누르면 GUI 채팅창이 켜진다 


#### [GUI 실행결과]
- user1, user2, user3가 접속하여 채팅중   
<img width="1510" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/08293253-e4b3-4d26-ad78-e2f8ced4246e">

- 채팅방을 나가는 사람이 있으면 나머지 사람들에게 나갔다는 안내 메시지 띄워줌   
<img height="450" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/52aa038a-7a76-4277-8920-a84c1acef273"> <img height="450" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/0f149b38-07ab-486f-9528-9af918b8ddcb">

#### [터미널 실행결과]
##### (Server)
- 클라이언트 연결시, Connected by client 메시지 콘솔에 출력
- 클라이언트가 채팅방을 나갈 때, 클라이언트로부터 연결이 끊겼다는 메시지 콘솔에 출력
<img width="458" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/fe7b07e2-fd5c-443d-b0bc-e10c573cf42e">


##### (Client)
- 클라이언트 코드 실행시, 채팅 닉네임 입력받는다
- 대화명(닉네임)을 입력하면 GUI 채팅창이 열리고, 채팅창에서 보내는 자신의 대화 내용과 상대방 메시지 내용이 콘솔에 찍힌다   
- 채팅방을 나가면, 다른 사용자들 콘솔창에 채팅방 종료 메시지를 출력해주고, 시스템이 종료된다

(user1)   
<img width="480" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/1986665f-1070-4958-9985-4110c1aadd14">

(user2)   
<img width="483" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/8a4a0571-87c0-45ea-905f-5aef25d0c06e">   

(user3)   
<img width="483" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/f6423715-7da3-49e1-8676-0f0f9b660d1f">   





