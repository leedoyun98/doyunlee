//package doyun.lee.api.cmm.utl;
//
//
//
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class CrawlingPage {
////    private static HSSFRow row;
////    private static HSSFCell cell;
//
//    static int p = 1;
//    static int q = 0;
//    static int z = 1;
//    static int start = 1;
//    static int gun = 0;
//
//
//    public void dataGenerator() throws InterruptedException {
//        world 파일 만드는 코드
//        HSSFWorkbook workbook = new HSSFWorkbook();
        // 엑셀 시트
//        HSSFSheet sheet = workbook.createSheet("crawlingData");
        // 꾸미기 css
//        CellStyle bodyStyle = workbook.createCellStyle();
//
//        bodyStyle.setBorderTop(BorderStyle.THIN);
//        bodyStyle.setBorderBottom(BorderStyle.THIN);
//        bodyStyle.setBorderLeft(BorderStyle.THIN);
//        bodyStyle.setBorderRight(BorderStyle.THIN);
//        bodyStyle.setAlignment(HorizontalAlignment.CENTER);
//          // chromDriver 및 경로 설정
//        System.setProperty("webdriver.chrome.driver", "/Users/jungjunwoo/Downloads/chromedriver 4");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000114129&dispCatNo=1000001000100010004&trackingCd=Search_Pop_PROD");
//
//         // 중간 3초 정도 타임
//        System.out.println("3초 대기");
//        Thread.sleep(3500);
//         // 화면 태그
//        driver.findElement(By.id("reviewInfo")).click();
//
//
//        while (z < 51) {
//            System.out.println("j값:" + z);
//            Thread.sleep(3000);
//
//            // 리뷰 클릭

//
//            List<WebElement> elementsList = driver.findElements(By.className("txt_inner"));
//            List<WebElement> dateList = driver.findElements(By.className("date"));
//            List<WebElement> starList = driver.findElements(By.className("score_area"));
//            List<WebElement> likeList = driver.findElements(By.className("recom_area"));
//            List<WebElement> nickNameList = driver.findElements(By.className("id"));
//            List<WebElement> titleList = driver.findElements(By.className("txt_oneline"));
//
//            for (int i = 0; i < elementsList.size(); i++) {
//                String text = elementsList.get(i).getText().replaceAll("[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]", "");
//                row = sheet.createRow(q);
//                // 1.userid
//                row.createCell(p).setCellValue(String.format("%d", start));
//                row.createCell(p + 1).setCellValue(nickNameList.get(i).getText());
//
//                if (text.length() > 255) {
//                    row.createCell(p + 2).setCellValue(elementsList.get(i).getText().replaceAll("[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]", "").substring(0, 254));
//
//                } else {
//                    row.createCell(p + 2).setCellValue(elementsList.get(i).getText().replaceAll("[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]", ""));
//                }
//                row.createCell(p + 3).setCellValue(dateList.get(i).getText());
//                // 좋아요
//                row.createCell(p + 4).setCellValue(likeList.get(i).getText().replaceAll("[^0-9]", ""));
//                // 별점
//                row.createCell(p + 5).setCellValue(starList.get(i).getText().substring(6, 7));
//
//
//                System.out.println("게시물:" + elementsList.get(i).getText());
//                System.out.println("날짜:" + dateList.get(i).getText());
//                System.out.println("좋아요:" + likeList.get(i).getText().replaceAll("[^0-9]", ""));
//                System.out.println("별점:" + starList.get(i).getText().substring(6, 7));
//                System.out.println("닉네임:" + nickNameList.get(i).getText());
//                System.out.println("대기! ");
//                Thread.sleep(2500);
//                System.out.println("------------------------------------------------");
//                ++q;
//                ++start;
//
//            }
//
//
//            Thread.sleep(4000);
//
//            elementsList.clear();
//            dateList.clear();
//            starList.clear();
//            nickNameList.clear();
//            likeList.clear();
//
//            System.out.println("나누기 결과:" + z % 10);
//
//            if (CrawlingPage.z % 10 == 0) {
//                System.out.println("다음 페이지");
//                Thread.sleep(2000);
//                driver.findElement(By.className("next")).click();
//                ++CrawlingPage.z;
//                System.out.println("현재페이지:" + z);
//                continue;
//            }
//
//
//            ++CrawlingPage.z;
//            System.out.println("j값:" + z);
//            if (CrawlingPage.z % 10 == 0) {
//                String page = String.format("/html/body/div[2]/div[8]/div/div[8]/div/div[7]/a[%d]", 10);
//                driver.findElement(By.xpath(page)).click();
//                continue;
//            }
//
//
//            String page = String.format("/html/body/div[2]/div[8]/div/div[8]/div/div[7]/a[%d]", CrawlingPage.z % 10);
//            driver.findElement(By.xpath(page)).click();
//            System.out.println(String.format("page %d로 이동", z));
//
//        }
//
//
//        FileOutputStream outFile;
//        try {
//            outFile = new FileOutputStream("CustomerData.csv");
//            workbook.write(outFile);
//            outFile.close();
//            System.out.println("고객데이터 생성완료");
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void main(String args[]) throws InterruptedException {
//        CrawlingPage crawlingPage = new CrawlingPage();
//        crawlingPage.dataGenerator();
//    }
//}