package com.andrefaustino.workshopmongodb.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andrefaustino.workshopmongodb.dto.AuthorDTO;
import com.andrefaustino.workshopmongodb.dto.CommentDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "post")
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
	private Instant date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	public Post() {
		
	}


	public Post(String id, Instant date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Instant getDate() {
		return date;
	}


	public void setDate(Instant date) {
		date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public AuthorDTO getAuthor() {
		return author;
	}


	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}


	public List<CommentDTO> getComments() {
		return comments;
	}


	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		return true;
	}
	
	
}