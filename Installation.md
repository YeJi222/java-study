## JDK17 다운
- 다운로드 링크 : https://www.oracle.com/java/technologies/downloads/#jdk17-mac
<img width="846" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/a1d3ab53-1fb1-457f-9523-a22916acd71e">

- ARM64 DMG Installer dmg 버전으로 다운   
https://download.oracle.com/java/17/latest/jdk-17_macos-aarch64_bin.dmg (즉시 다운)
- dmg 설치 후, 아래 경로에 저장된다
```sh
/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
```

## 이클립스 JRE 설정
- Eclipse -> Preferences -> (Java > Installed JRES)
<img width="501" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/14d57de7-2069-40fe-b07a-1f742124a718">

- Add -> Standard VM -> JRE home 추가    
/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home 경로 추가
<img width="579" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/4c40a610-1c6d-4b35-aad1-a42b2561a62a">

- 체크하고 Apply
<img width="442" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/a25e9ec1-8ae3-4164-be36-1b0b5b108a14">

## Dynamic Web Project 생성
- 프로젝트 이름 myapp으로 생성 
<img width="625" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/bd899aa0-b2f0-4341-8e25-1e9596369375">

<img width="627" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/afe03b48-f4bf-41e2-9067-b861ef7bdceb">

- myapp/src/main/webapp/index.html 생성 
<img width="544" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/42fbce6c-71ba-4b87-9236-3204f5a744db">

## 톰캣 설치
<img width="487" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/8ffc0d4c-a800-412c-a504-6a04c538378b">

- zip으로 다운   
https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.80/bin/apache-tomcat-9.0.80.zip (즉시 다운)  
- poscodx 폴더에 압축 풀기
<img width="404" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/48f09089-3a4c-4db3-9555-36aecfe28152">

- No servers are available ~ 클릭하여 톰캣 서버 추가
<img width="583" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/e73d2aa2-5ece-40e4-8c9c-36e6415a028c">

- 톰캣 압축 푼 경로 지정 후, Finish 
<img width="579" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/4212f76f-9682-4163-9e50-211c6cd7d277">

- 톰캣 추가 완료
<img width="421" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/33710312-03f0-48fb-a4be-e2f1d7cb4777">

- index.html에서 Run On Server
- 다음과 같이 세팅 후, finish
<img width="581" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/edff48f6-5209-4a0a-8102-f447d612e577">

<img width="578" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/a2a11b77-6448-4bdf-95c0-ebf794142ffc">

- 실행결과   
http://localhost:8080/myapp/index.html   
<img width="876" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/962c5238-cda1-4bd8-bc97-829e822ebdf3">









