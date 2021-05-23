package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.WebPage;
import pages.components.WebComponent;
import pages.components.impl.SearchResultItemComponent;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage {
//    @FindBy(css = ".repo-list-item")
//    private List<WebElement> searchResultsItems;

    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.cssSelector(".repo-list-item");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> searchResultsItemsText() {
        return searchResultsItems().stream()
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemsWithText(String searchText){
        return searchResultsItems().stream()
                .filter(item-> item.containsSearchPhrase(searchText))
                .map(WebComponent::getText)
                .collect(Collectors.toList());
    }

    private List<SearchResultItemComponent> searchResultsItems(){
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultItemComponent::new)
                .collect(Collectors.toList());
    }



}
