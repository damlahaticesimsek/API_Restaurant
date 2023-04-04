package com.restaurant.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.SesClientBuilder;
import software.amazon.awssdk.services.ses.model.*;


@Service
public class EmailSenderService {

    private static Logger logger = LoggerFactory.getLogger(EmailSenderService.class);

    @Value("${aws.ses.send.email.from}")
    private String FROM;
    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.access.key}")
	private String access;

	@Value("${aws.secret.access.key}")
	private String secret;


    public void sendEmail(String to, String htmlBody, String subject) throws RuntimeException {
        sendEmailWithSES(htmlBody,subject,Destination.builder().toAddresses(to).build());
    }

	private SesClient createSesClient() {
		SesClientBuilder builder = SesClient.builder();

		builder = builder.region(Region.of(awsRegion));
		AwsCredentials credentials = AwsBasicCredentials.create(access, secret);
		builder.credentialsProvider(StaticCredentialsProvider.create(credentials));
		SesClient sesClient = builder.build();
		return sesClient;
	}

    private void sendEmailWithSES(String htmlBody, String subject, Destination destination) throws RuntimeException {

        //then send
    	try(var client = createSesClient()) {

        	SendEmailRequest request = SendEmailRequest.builder()
                .destination(destination)
                .message(Message.builder()
                        .subject(Content.builder().data(subject).build())
                        .body(Body.builder().html(Content.builder().data(htmlBody).build()).build())
                        .build())
                .source(FROM)
                .build();

	        SendEmailResponse sendEmailResponse = client.sendEmail(request);
	        if(sendEmailResponse.sdkHttpResponse().isSuccessful()) {
				logger.info("Mail sent to " + destination.toAddresses().get(0));
	        }
	        else {
				throw new RuntimeException("Failed to send mail, statusCode: " + sendEmailResponse.sdkHttpResponse().statusCode());
	        }
        } catch (SesException ex){
			logger.error("Failed to send mail", ex);
            throw new RuntimeException(ex.getMessage());
        }
    }
}
