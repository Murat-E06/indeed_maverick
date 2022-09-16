package com.indeed.uk.pages;

import com.indeed.uk.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LocalDetailPage extends RemoteDetailPage {

    public LocalDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
