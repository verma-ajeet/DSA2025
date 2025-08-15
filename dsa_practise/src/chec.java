//import java.util.List;
//import java.util.Map;
//
//public class chec {
//
//	public void abd() {
//		List<Map<String, AttributeValue>> attributeValues = dynamoDBHelper
//				.getScanResult(DF2EnvironmentConstants.AWS_DYNAMO_DB_TABLE).getItems();
//		int actualNumberOfUIDS = dynamoDBHelper.getDistinctRecords(attributeValues).size();
//		int retry = 1;
//		while (JSON_UID_AND_VERSION.size() != actualNumberOfUIDS || retry <= 5) {
//			TimeUnit.SECONDS.sleep(10);
//			attributeValues = dynamoDBHelper.getScanResult(DF2EnvironmentConstants.AWS_DYNAMO_DB_TABLE).getItems();
//			actualNumberOfUIDS = dynamoDBHelper.getDistinctRecords(attributeValues).size();
//			retry += 1;
//		}
//		assertEquals("No records are processed in DynamoDB", JSON_UID_AND_VERSION.size(), actualNumberOfUIDS);
//		for (String UID : JSON_UID_AND_VERSION.keySet()) {
//			boolean uidChecked = false;
//			for (Map.Entry<String, String> entry : dynamoDBHelper.getDistinctRecords(attributeValues).entrySet()) {
//				if (UID.equals(entry.getKey())) {
//					boolean isTransformed = Arrays.osList("FAILED", "SUCCESS").contains(entry.getValue());
//					assertTrue("uid:" + entry.getKey() + "sent successfully to DynamoDB with status: isTransformed",
//							isTransformed);
//					uidChecked = true;
//					break;
//				}
//			}
//			if (!uidChecked) {
//				Assert.fail(UID + "UID is not processed in DynamoDB");
//			}
//		}
//	}
//}
