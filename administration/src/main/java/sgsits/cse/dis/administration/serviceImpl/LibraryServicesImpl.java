package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.model.LibraryBookRecords;
import sgsits.cse.dis.administration.repo.LibraryBookRecordsRepository;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.response.LibraryBookRecordsResponse;
import sgsits.cse.dis.administration.service.LibraryServices;

@Component
public class LibraryServicesImpl implements LibraryServices {
	
	@Autowired
	LibraryBookRecordsRepository libraryBookRecordsRepository;
	
	@Override
	public boolean addBook(AddBookForm addBookForm) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		LibraryBookRecords libraryBookRecord = new LibraryBookRecords();
		libraryBookRecord.setAuthorName(addBookForm.getAuthorName());
		libraryBookRecord.setIsbn(addBookForm.getIsbn());
		libraryBookRecord.setEdition(addBookForm.getEdition());
		libraryBookRecord.setEntryDate(simpleDateFormat.format(new Date()));
		libraryBookRecord.setNoOfPages(addBookForm.getNoOfPages());
		libraryBookRecord.setPrice(addBookForm.getPrice());
		libraryBookRecord.setPublisherAndPlace(addBookForm.getPublisherAndPlace());
		libraryBookRecord.setPurchaseDate(addBookForm.getPurchaseDate());
		libraryBookRecord.setRemarks(addBookForm.getRemarks());
		libraryBookRecord.setSubjectCategory(addBookForm.getSubjectCategory());
		libraryBookRecord.setTitle(addBookForm.getTitle());
		libraryBookRecord.setYearOfPublication(addBookForm.getYearOfPublication());
		
		LibraryBookRecords test = libraryBookRecordsRepository.save(libraryBookRecord);
		if (test!=null) 
			return true;
		else 
			return false;
	}
	
	@Override
	public List<LibraryBookRecordsResponse> getAllBooks(){
		List<LibraryBookRecords> libraryBookRecords; 
		List<LibraryBookRecordsResponse> libraryBookRecordsResponses = new ArrayList<LibraryBookRecordsResponse>();
		LibraryBookRecordsResponse temp=new LibraryBookRecordsResponse();
		libraryBookRecords = libraryBookRecordsRepository.findAll();
		for(LibraryBookRecords libraryBookRecord : libraryBookRecords) {
			temp.setAuthorName(libraryBookRecord.getAuthorName());
			temp.setEdition(libraryBookRecord.getEdition());
			temp.setStatus(libraryBookRecord.getStatus());
			temp.setTitle(libraryBookRecord.getTitle());
			libraryBookRecordsResponses.add(temp);
		}
		return libraryBookRecordsResponses;
	}
}

