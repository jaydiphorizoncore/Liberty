package com.example.liberty.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.liberty.R
import com.example.liberty.ui.home.adapter.CategoryAdapter
import com.example.liberty.ui.home.adapter.CoursesAdapter
import com.example.liberty.ui.home.adapter.DailyQuizAdapter
import com.example.liberty.ui.home.adapter.PackageAdapter
import com.example.liberty.ui.home.adapter.TestimonialAdapter
import com.example.liberty.ui.home.adapter.ToppersAdapter
import com.example.liberty.ui.home.adapter.ViewPagerAdapter
import com.example.liberty.ui.home.dataclass.CategoryData
import com.example.liberty.ui.home.dataclass.CoursesData
import com.example.liberty.ui.home.dataclass.DailyQuizData
import com.example.liberty.ui.home.dataclass.PackageData
import com.example.liberty.ui.home.dataclass.TestimonialData
import com.example.liberty.ui.home.dataclass.ToppersData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


class HomeFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    private lateinit var btnAllCourses: Button
    private lateinit var btnPopular: Button
    private lateinit var btnNewest: Button
    private lateinit var btnAdvance: Button

    private lateinit var packageRecyclerView: RecyclerView
    private lateinit var coursesRecyclerView: RecyclerView
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var testimonialRecyclerView: RecyclerView
    private lateinit var toppersRecyclerView: RecyclerView
    private lateinit var dailyQuizRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initView(view)
        clickListener()
        preparePackageRecyclerView()
        prepareCoursesRecyclerView()
        prepareCategoryRecyclerView()
        prepareTestimonialRecyclerView()
        prepareToppersRecyclerView()
        prepareDailyQuizRecyclerView()
        return view
    }

    private fun clickListener() {

        btnAllCourses.isSelected = true

        btnAllCourses.setOnClickListener {
            btnAllCourses.setBackgroundResource(R.drawable.button_style)
            btnAllCourses.isSelected = true
            btnPopular.isSelected = false
            btnAdvance.isSelected = false
            btnNewest.isSelected = false
        }
        btnPopular.setOnClickListener {
            btnPopular.setBackgroundResource(R.drawable.button_style)
            btnAllCourses.isSelected = false
            btnPopular.isSelected = true
            btnAdvance.isSelected = false
            btnNewest.isSelected = false
        }
        btnNewest.setOnClickListener {
            btnPopular.setBackgroundResource(R.drawable.button_style)
            btnAllCourses.isSelected = false
            btnPopular.isSelected = false
            btnAdvance.isSelected = false
            btnNewest.isSelected = true
        }
        btnAdvance.setOnClickListener {
            btnPopular.setBackgroundResource(R.drawable.button_style)
            btnAllCourses.isSelected = false
            btnPopular.isSelected = false
            btnAdvance.isSelected = true
            btnNewest.isSelected = false
        }

    }


    private fun preparePackageRecyclerView() {
        val itemList = ArrayList<PackageData>()
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )

        val packageRecyclerAdapter = PackageAdapter(itemList)
        packageRecyclerView.adapter = packageRecyclerAdapter
    }

    private fun prepareCoursesRecyclerView() {
        val itemList = ArrayList<CoursesData>()

        itemList.add(
            CoursesData(
                "Popular",
                R.drawable.ic_course_dp,
                "₹ 3000/-",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Videos",
                "250 Materials",
                "300 Tests",
                Color.parseColor("#14AE5C")
            )
        )
        itemList.add(
            CoursesData(
                "Popular",
                R.drawable.ic_course_dp,
                "₹ 2000/-",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Videos",
                "250 Materials",
                "300 Tests",
                Color.parseColor("#FD6584")
            )
        )
        itemList.add(
            CoursesData(
                "Popular",
                R.drawable.ic_course_dp,
                "₹ 5000/-",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Videos",
                "250 Materials",
                "300 Tests",
                Color.parseColor("#14AE5C")
            )
        )
        itemList.add(
            CoursesData(
                "Popular",
                R.drawable.ic_course_dp,
                "₹ 2000/-",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Videos",
                "250 Materials",
                "300 Tests",
                Color.parseColor("#FD6584")
            )
        )

        val coursesRecyclerAdapter = CoursesAdapter(itemList)
        coursesRecyclerView.adapter = coursesRecyclerAdapter
    }

    private fun prepareCategoryRecyclerView() {

        val itemList = ArrayList<CategoryData>()
        itemList.add(CategoryData(R.drawable.ic_paper_solution, "GSCB Paper Solution"))
        itemList.add(CategoryData(R.drawable.ic_mathes, "Maths"))
        itemList.add(CategoryData(R.drawable.ic_english_grammer, "English Grammar"))
        itemList.add(CategoryData(R.drawable.ic_gujarat_culture, "Gujarati Culture"))

        val categoryAdapter = CategoryAdapter(itemList)
        categoryRecyclerView.adapter = categoryAdapter
    }

    private fun prepareTestimonialRecyclerView() {
        val itemList = ArrayList<TestimonialData>()

        itemList.add(
            TestimonialData(
                R.drawable.ic_testimonial,
                "Ravindar Mehta",
                "Ravindar Mehta Ravindar Mehta Ravindar Mehta Ravindar Mehta..."
            )
        )
        itemList.add(
            TestimonialData(
                R.drawable.ic_testimonial,
                "Ravindar Mehta",
                "Ravindar Mehta Ravindar Mehta Ravindar Mehta Ravindar Mehta..."
            )
        )
        itemList.add(
            TestimonialData(
                R.drawable.ic_testimonial,
                "Ravindar Mehta",
                "Ravindar Mehta Ravindar Mehta Ravindar Mehta Ravindar Mehta..."
            )
        )

        val testimonialAdapter = TestimonialAdapter(itemList)
        testimonialRecyclerView.adapter = testimonialAdapter

    }

    private fun prepareToppersRecyclerView() {
        val itemList = ArrayList<ToppersData>()
        itemList.add(ToppersData(R.drawable.ic_toppers, "Divyang Patel", "GPSC Class 12"))
        itemList.add(ToppersData(R.drawable.ic_toppers2, "Mamtaben Popat", "GPSC Class 12"))
        itemList.add(ToppersData(R.drawable.ic_toppers, "Divyang Patel", "GPSC Class 12"))
        itemList.add(ToppersData(R.drawable.ic_toppers2, "Mamtaben Popat", "GPSC Class 12"))


        val topperAdapter = ToppersAdapter(itemList)
        toppersRecyclerView.adapter = topperAdapter
    }

    private fun prepareDailyQuizRecyclerView() {
        val itemList = ArrayList<DailyQuizData>()
        itemList.add(DailyQuizData("Test- 1315 GSCB Mix Test", 50, 30))
        itemList.add(DailyQuizData("Test- 1315 GSCB Mix Test", 50, 30))
        itemList.add(DailyQuizData("Test- 1315 GSCB Mix Test", 50, 30))

        val dailyQuizAdapter = DailyQuizAdapter(itemList)
        dailyQuizRecyclerView.adapter = dailyQuizAdapter
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_circle_tab))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_circle_tab))*/
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())

        val adapter = ViewPagerAdapter(parentFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun initView(view: View) {
        tabLayout = view.findViewById(R.id.tab_ll)
        viewPager = view.findViewById(R.id.viewPager)

        btnAllCourses = view.findViewById(R.id.btn_allCourse)
        btnPopular = view.findViewById(R.id.btn_popular)
        btnNewest = view.findViewById(R.id.btn_newest)
        btnAdvance = view.findViewById(R.id.btn_advance)

        packageRecyclerView = view.findViewById(R.id.recycler_packages)
        coursesRecyclerView = view.findViewById(R.id.recycler_courses)
        categoryRecyclerView = view.findViewById(R.id.recycler_category)
        testimonialRecyclerView = view.findViewById(R.id.recycler_testimonial)
        toppersRecyclerView = view.findViewById(R.id.recycler_topper)
        dailyQuizRecyclerView = view.findViewById(R.id.recycler_DailyQuiz)
    }

}