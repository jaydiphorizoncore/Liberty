package com.example.liberty.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.liberty.R
import com.example.liberty.network.ApiInterface
import com.example.liberty.network.ApiRepository
import com.example.liberty.network.DashboardInterface
import com.example.liberty.network.response.DashboardResponse
import com.example.liberty.network.viewmodel.ApiViewModel
import com.example.liberty.network.viewmodel.ViewModelFactory
import com.example.liberty.ui.home.adapter.CategoryAdapter
import com.example.liberty.ui.home.adapter.CoursesAdapter
import com.example.liberty.ui.home.adapter.DailyQuizAdapter
import com.example.liberty.ui.home.adapter.PackageAdapter
import com.example.liberty.ui.home.adapter.TestimonialAdapter
import com.example.liberty.ui.home.adapter.ToppersAdapter
import com.example.liberty.ui.home.adapter.ViewPagerAdapter
import com.example.liberty.ui.home.dataclass.PackageData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


class HomeFragment : Fragment(), DashboardInterface {
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

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var testimonialAdapter: TestimonialAdapter
    private lateinit var toppersAdapter: ToppersAdapter
    private lateinit var quizAdapter: DailyQuizAdapter
    private lateinit var coursesAdapter: CoursesAdapter

    private lateinit var viewModel: ApiViewModel

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

        val api = ApiInterface()
        val repository = ApiRepository(api)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[ApiViewModel::class.java]
        viewModel.dashboardInterface = this
        viewModel.getDashboard()
        return view
    }

    private fun clickListener() {


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
        coursesAdapter = CoursesAdapter(requireContext(), ArrayList())
        coursesRecyclerView.adapter = coursesAdapter
    }

    private fun prepareCategoryRecyclerView() {

        categoryAdapter = CategoryAdapter(requireContext(), ArrayList())
        categoryRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryAdapter
        }

    }

    private fun prepareTestimonialRecyclerView() {
        testimonialAdapter = TestimonialAdapter(requireContext(), ArrayList())

        testimonialRecyclerView.apply {
            setHasFixedSize(true)
            adapter = testimonialAdapter
        }
    }

    private fun prepareToppersRecyclerView() {

        toppersAdapter = ToppersAdapter(requireContext(), ArrayList())
        toppersRecyclerView.adapter = toppersAdapter

    }

    private fun prepareDailyQuizRecyclerView() {
        quizAdapter = DailyQuizAdapter(requireContext(), ArrayList())
        dailyQuizRecyclerView.adapter = quizAdapter
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

    override fun onStarted() {
        Log.d("TAG", "onStarted")
    }

    override fun onSuccess(dashboardResponse: DashboardResponse?) {
        btnAllCourses.isSelected = true
        if (dashboardResponse != null) {
            Log.d("TAG", "onSuccess")
            categoryAdapter.setData(dashboardResponse.data.categories)
            testimonialAdapter.setData(dashboardResponse.data.testimonials.testimonialsData)
            toppersAdapter.setData(dashboardResponse.data.toppers.topersData)
            quizAdapter.setData(dashboardResponse.data.tests)

            btnAllCourses.setOnClickListener {
                btnAllCourses.setBackgroundResource(R.drawable.button_style)
                btnAllCourses.isSelected = true
                btnPopular.isSelected = false
                btnAdvance.isSelected = false
                btnNewest.isSelected = false
                coursesAdapter.setAllData(dashboardResponse.data.courses.allCourses.courses)
            }
            btnPopular.setOnClickListener {
                btnPopular.setBackgroundResource(R.drawable.button_style)
                btnAllCourses.isSelected = false
                btnPopular.isSelected = true
                btnAdvance.isSelected = false
                btnNewest.isSelected = false
                coursesAdapter.setAllData(dashboardResponse.data.courses.popularCourses.courses)

            }
            btnAdvance.setOnClickListener {
                btnPopular.setBackgroundResource(R.drawable.button_style)
                btnAllCourses.isSelected = false
                btnPopular.isSelected = false
                btnAdvance.isSelected = true
                btnNewest.isSelected = false
                coursesAdapter.setAllData(dashboardResponse.data.courses.advanceCourses.courses)
            }
            btnNewest.setOnClickListener {
                btnPopular.setBackgroundResource(R.drawable.button_style)
                btnAllCourses.isSelected = false
                btnPopular.isSelected = false
                btnAdvance.isSelected = false
                btnNewest.isSelected = true

                if (dashboardResponse.data.courses.advanceCourses == null) {
                    coursesRecyclerView.visibility = View.INVISIBLE

                } else {
                    coursesAdapter.setAllData(dashboardResponse.data.courses.advanceCourses.courses)
                }
            }

        }
    }

    override fun onFailure(message: String) {
        Log.d("TAG", "onFailure")
    }

}