package sgsits.cse.dis.administration.serviceImpl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.feignClient.UserClient;
import sgsits.cse.dis.administration.model.LibraryBookCount;
import sgsits.cse.dis.administration.model.LibraryBookRecords;
import sgsits.cse.dis.administration.model.LibraryCurrentIssues;
import sgsits.cse.dis.administration.model.LibrarySettings;
import sgsits.cse.dis.administration.model.LibraryThesisRecords;
import sgsits.cse.dis.administration.repo.LibraryBookCountRepository;
import sgsits.cse.dis.administration.repo.LibraryBookRecordsRepository;
import sgsits.cse.dis.administration.repo.LibraryCurrentIssuesRepository;
import sgsits.cse.dis.administration.repo.LibrarySettingsRepository;
import sgsits.cse.dis.administration.repo.LibraryThesisRecordsRepository;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.request.AddThesisForm;
import sgsits.cse.dis.administration.request.IssueForm;
import sgsits.cse.dis.administration.service.LibraryServices;
import sgsits.cse.dis.administration.util.CalenderGeneralServices;

@Component
public class LibraryServicesImpl implements LibraryServices, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LibraryBookRecordsRepository libraryBookRecordsRepository;

	@Autowired
	private LibraryBookCountRepository libraryBookCountRepository;

	@Autowired
	private LibraryThesisRecordsRepository libraryThesisRecordsRepository;

	@Autowired
	private LibrarySettingsRepository librarySettingsRepository;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired 
	private LibraryCurrentIssuesRepository libraryCurrentIssuesRepository;

	@Transactional
	@Override
	public String addBook(AddBookForm addBookForm) throws ConflictException {
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
		String bookId = generateBookId(addBookForm.getSubjectCategory());
		libraryBookRecord.setBookId(bookId);
		LibraryBookRecords test = libraryBookRecordsRepository.save(libraryBookRecord);
		if (test.equals(null))
			throw new ConflictException("Book cannot be added. This is due to conflict in information on client side.");
		return bookId;
	}

	@Override
	public List<LibraryBookRecords> getAllBooks() {
		return libraryBookRecordsRepository.findAll();
	}

	@Override
	public List<LibraryBookRecords> getBookByTitle(String title) throws EventDoesNotExistException {
		List<LibraryBookRecords> libraryBookRecords;
		libraryBookRecords = libraryBookRecordsRepository.findByTitleContainingIgnoreCase(title);
		if (libraryBookRecords.isEmpty())
			throw new EventDoesNotExistException("Book with Title [" + title + "] doesn't exist.");
		return libraryBookRecords;
	}

	@Override
	public List<LibraryBookRecords> getBookByBookId(String bookId) throws EventDoesNotExistException {
		List<LibraryBookRecords> libraryBookRecords;
		libraryBookRecords = libraryBookRecordsRepository.findByBookIdContainingIgnoreCase(bookId);
		if (libraryBookRecords.isEmpty())
			throw new EventDoesNotExistException("Book with book id [" + bookId + "] doesn't exist.");
		return libraryBookRecords;
	}

	@Override
	public List<LibraryBookRecords> getBookByAuthorName(String authorName) throws EventDoesNotExistException {
		List<LibraryBookRecords> libraryBookRecords;
		libraryBookRecords = libraryBookRecordsRepository.findByAuthorNameContainingIgnoreCase(authorName);
		if (libraryBookRecords.isEmpty())
			throw new EventDoesNotExistException("Book with author name [" + authorName + "] doesn't exist.");
		return libraryBookRecords;
	}

	// Helper function to generate book-id

	private String generateBookId(String subjectCategory) {
		LibraryBookCount libraryBookCount = new LibraryBookCount(subjectCategory);
		if (libraryBookCountRepository.findBySubjectCategory(subjectCategory).isEmpty()) {
			libraryBookCount.setCount(1l);
			libraryBookCount.setSubjectCategory(subjectCategory);
			libraryBookCountRepository.save(libraryBookCount);

		} else {
			libraryBookCountRepository.updateCount(subjectCategory);
			libraryBookCount = libraryBookCountRepository.findBySubjectCategory(subjectCategory).get(0);
			libraryBookCount.setCount(libraryBookCount.getCount() + 1);

		}

		return libraryBookCount.getSubjectCategory() + "-" + libraryBookCount.getCount();
	}

	@Override
	public void updateBook(AddBookForm addBookForm, String bookId)
			throws EventDoesNotExistException, ConflictException {

		if (libraryBookRecordsRepository.existsByBookId(bookId)) {
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
			libraryBookRecord.setBookId(bookId);
			LibraryBookRecords test = libraryBookRecordsRepository.save(libraryBookRecord);
			if (test.equals(null))
				throw new ConflictException("Book with book id [" + bookId + "] couldn't be updated.");
		} else
			throw new EventDoesNotExistException("Book with thesis id [" + bookId + "] not found.");

	}

	@Transactional
	@Override
	public void deleteBook(String bookId) throws EventDoesNotExistException, ConflictException {
		if (libraryBookRecordsRepository.existsByBookId(bookId)) {
			if (libraryBookRecordsRepository.deleteByBookId(bookId) <= 0)
				throw new ConflictException("Unable to delete book with book id: " + bookId + ".");
		} else
			throw new EventDoesNotExistException("Book with book id: " + bookId + " doesn't exist.");

	}

	// Thesis Services
	@Override
	public Long addThesis(AddThesisForm addThesisForm) throws ConflictException {

		LibraryThesisRecords test = libraryThesisRecordsRepository
				.save(new LibraryThesisRecords(addThesisForm.getYear(), addThesisForm.getSubmittedBy(),
						addThesisForm.getGuidedBy(), addThesisForm.getCdStatus(), addThesisForm.getCourse(),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), addThesisForm.getTitle(),
						addThesisForm.getRemarks()));

		if (test.equals(null))
			throw new ConflictException("No records updated. This is due to conflict in information on client side.");

		return test.getThesisId();
	}

	@Override
	public List<LibraryThesisRecords> getAllThesis() {
		return libraryThesisRecordsRepository.findAll();
	}

	@Override
	public List<LibraryThesisRecords> getThesisByTitle(String title) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByTitleContainingIgnoreCase(title);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with title [" + title + "] doesn't exist.");
		return libraryThesisRecords;
	}

	@Override
	public List<LibraryThesisRecords> getThesisBySubmittedBy(String submittedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findBySubmittedByContainingIgnoreCase(submittedBy);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with submitted by [" + submittedBy + "] doesn't exist.");
		return libraryThesisRecords;
	}

	@Override
	public List<LibraryThesisRecords> getThesisByGuidedBy(String guidedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByGuidedByContainingIgnoreCase(guidedBy);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with guided by [" + guidedBy + "] doesn't exist.");
		return libraryThesisRecords;
	}

	@Override
	public List<LibraryThesisRecords> getThesisByThesisId(long thesisId) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByThesisId(thesisId);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with thesis id [" + thesisId + "] doesn't exist.");
		return libraryThesisRecords;
	}

	@Override
	public List<LibraryThesisRecords> getThesisByCourse(String course) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByCourseContainingIgnoreCase(course);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with course [" + course + "] doesn't exist.");
		return libraryThesisRecords;
	}

	@Override
	public void updateThesis(AddThesisForm addThesisForm, long thesisId)
			throws EventDoesNotExistException, ConflictException {
		if (libraryThesisRecordsRepository.existsByThesisId(thesisId)) {
			LibraryThesisRecords test = libraryThesisRecordsRepository
					.save(new LibraryThesisRecords(thesisId, addThesisForm.getYear(), addThesisForm.getSubmittedBy(),
							addThesisForm.getGuidedBy(), addThesisForm.getCdStatus(), addThesisForm.getCourse(),
							new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), addThesisForm.getTitle(),
							addThesisForm.getRemarks()));

			if (test.equals(null))
				throw new ConflictException("Thesis with thesis id [" + thesisId + "] couldn't be updated");

		} else
			throw new EventDoesNotExistException("Thesis with thesis id [" + thesisId + "] not found.");

	}

	@Transactional
	@Override
	public void deleteThesis(long thesisId) throws EventDoesNotExistException, ConflictException {
		if (libraryThesisRecordsRepository.existsByThesisId(thesisId)) {
			if (libraryThesisRecordsRepository.deleteByThesisId(thesisId) <= 0)
				throw new ConflictException("Unable to delete thesis with thesis id: " + thesisId + ".");
		} else
			throw new EventDoesNotExistException("Thesis with thesis id: " + thesisId + " doesn't exist.");
	}

	@Override
	public List<LibrarySettings> getSetting() {
		return librarySettingsRepository.findAll();

	}

	@Transactional
	@Override
	public void updateSettings(LibrarySettings librarySettings) throws EventDoesNotExistException {
		if (librarySettingsRepository.save(librarySettings).equals(null)) {
			throw new EventDoesNotExistException("Couldn't update the settings");
		}
	}

	@Transactional
	@Override
	public String issue(IssueForm issueForm) throws EventDoesNotExistException, ConflictException {
		String response;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(userClient.existsByUsername(issueForm.getUsername())){
			System.out.println(issueForm.getUsername());
			if(issueForm.getThesisId() != null) {
				System.out.println("FLAG 0");
				response = "Failed to issue Thesis with id "+issueForm.getThesisId()
				+" to user "+issueForm.getUsername();
				System.out.println("FLAG 1");
				LibraryThesisRecords libraryThesisRecords = 
						libraryThesisRecordsRepository.findByThesisId(issueForm.getThesisId()).get(0);
				System.out.println("FLAG 2");
				libraryThesisRecords.setStatus("Issued");
				libraryThesisRecordsRepository.save(libraryThesisRecords);
				System.out.println("FLAG 3");
				LibraryCurrentIssues test = new LibraryCurrentIssues(issueForm.getUsername(),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),
						simpleDateFormat.format(CalenderGeneralServices.addDays(new Date(),
								Integer.parseInt(String.valueOf(getSetting().get(0).getReturnDeadlineDays())))),
						libraryThesisRecords.getTitle(),issueForm.getBookId(),issueForm.getThesisId());
				if(libraryCurrentIssuesRepository.save(test).equals(null)) {
					throw new ConflictException(response);
				}
				else {
					response = "Thesis id ["+issueForm.getThesisId()+
								"]\nBook name ["+libraryThesisRecords.getTitle()+
								"]\nissued to ["+issueForm.getUsername()+"]";
				}
			}
			else{
				//issue book
				System.out.println("FLAG 5");
				response = "Failed to issue book with id "+issueForm.getBookId()
				+" to user "+issueForm.getUsername();
				LibraryBookRecords libraryBookRecords = 
						libraryBookRecordsRepository.findByBookIdContainingIgnoreCase(issueForm.getBookId()).get(0);
				libraryBookRecords.setStatus("Issued");
				libraryBookRecordsRepository.save(libraryBookRecords);
				LibraryCurrentIssues test = new LibraryCurrentIssues(issueForm.getUsername(),
						simpleDateFormat.format(new Date()),
						simpleDateFormat.format(CalenderGeneralServices.addDays(new Date(),
								Integer.parseInt(String.valueOf(getSetting().get(0).getReturnDeadlineDays())))),
						libraryBookRecords.getTitle(),libraryBookRecords.getBookId(),issueForm.getThesisId());
				if(libraryCurrentIssuesRepository.save(test).equals(null)) {
					throw new ConflictException(response);
				}
				else {
					response = "Book id ["+issueForm.getBookId()+
								"]\nBook name ["+libraryBookRecords.getTitle()+
								"]\nissued to ["+issueForm.getUsername()+"]";
				}
			}
		}
		//User not found
		else {
			throw new EventDoesNotExistException("username with "+issueForm.getUsername()+" not found.");
		}
		return response;
	}

}



