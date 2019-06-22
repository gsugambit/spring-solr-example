package com.raymond.solr.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "employee")
@Builder
public class Employee {

	@Id
	@Field
	private String id;
	
	@Field
	@Indexed
	private String firstName;
	
	@Field
	@Indexed
	private String lastName;
	
	@Field
	private String[] address;
}
